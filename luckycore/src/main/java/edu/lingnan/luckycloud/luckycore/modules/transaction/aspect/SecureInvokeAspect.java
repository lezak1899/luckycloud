package edu.lingnan.luckycloud.luckycore.modules.transaction.aspect;


import edu.lingnan.luckycloud.luckycore.modules.transaction.annotation.SecureInvoke;
import edu.lingnan.luckycloud.luckycore.modules.transaction.domain.dto.SecureInvokeDTO;
import edu.lingnan.luckycloud.luckycore.modules.transaction.domain.entity.SecureInvokeRecord;
import edu.lingnan.luckycloud.luckycore.modules.transaction.service.SecureInvokeService;
import edu.lingnan.luckycloud.luckycore.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE + 1)//确保最先执行
@Component
public class SecureInvokeAspect {
    @Autowired
    private SecureInvokeService secureInvokeService;

    @Around("@annotation(secureInvoke)")
    public Object around(ProceedingJoinPoint joinPoint, SecureInvoke secureInvoke) throws Throwable {
        boolean async = secureInvoke.async();
        //Spring框架中的一个静态方法，用于判断当前线程是否处于活动的事务环境中。
        boolean inTransaction = TransactionSynchronizationManager.isActualTransactionActive();
        //非事务状态，直接执行，不做任何保证。
        if (!inTransaction) {
            return joinPoint.proceed();
        }
        // 通过反射获取方法名称
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        // 通过反射活动参数名称
        List<String> parameters = Stream.of(method.getParameterTypes()).map(Class::getName).collect(Collectors.toList());

        SecureInvokeDTO dto = SecureInvokeDTO.builder()
                .args(JsonUtils.toStr(joinPoint.getArgs()))
                .className(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(JsonUtils.toStr(parameters))
                .build();
        SecureInvokeRecord record = SecureInvokeRecord.builder()
                .secureInvokeDTO(dto)
                .maxRetryTimes(secureInvoke.maxRetryTimes())
                .build();
        // 交给分布式事务去执行
        secureInvokeService.invoke(record, async);
        return null;
    }
}
