package com.francis.common.utils;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 22:27
 */
@Slf4j
public class MessageUtils {
    public static String getErrorMessage(Throwable t) {
        String message = "Sorry, Exception...";
        if (t instanceof FlowException) {
            message = "触发了流控规则";
        } else if (t instanceof ParamFlowException) {
            message = "触发了参数规则";
        } else if (t instanceof AuthorityException) {
            message = "触发了权限规则";
        } else if (t instanceof SystemBlockException) {
            message = "触发了系统规则";
        } else if (t instanceof DegradeException) {
            message = "触发了降级规则";
        }
        log.warn("====== {}", message);
        return message;
    }
}
