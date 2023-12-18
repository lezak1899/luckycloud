package edu.lingnan.luckycloud.luckycore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * .【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方
 * 式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors 返回的线程池对象的弊端如下：
 * 1）FixedThreadPool 和 SingleThreadPool：
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2）CachedThreadPool：
 * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
 * 3）ScheduledThreadPool：
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Value("${threadPool.corePoolSize}")
    private int corePoolSize;

    @Value("${threadPool.maxPoolSize}")
    private int maxPoolSize;

    @Value("${threadPool.queueCapacity}")
    private int queueCapacity;

    @Value("${threadPool.threadNamePrefix}")
    private String threadNamePrefix;

    @Value("${threadPool.keepAliveTime}")
    private int keepAliveTime;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池的核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置线程池的最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置线程池的队列容量
        executor.setQueueCapacity(queueCapacity);
        // 线程前缀名称，方便辨别
        executor.setThreadNamePrefix(threadNamePrefix);
        // 非核心线程数的存活时间
        executor.setKeepAliveSeconds(keepAliveTime);
        //线程池的拒绝策略,默认策略，丢弃任务并抛出RejectedExecutionException异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

}
