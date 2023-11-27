package edu.lingnan.luckycloud.luckycore.modules.transaction.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Data Transfer Object 意为“数据传输对象”。DTO通常用于在不同层之间传输数据，例如在Controller层和Service层之间传输数据。
public class SecureInvokeDTO {
    private String className;
    private String methodName;
    private String parameterTypes;
    private String args;
}
