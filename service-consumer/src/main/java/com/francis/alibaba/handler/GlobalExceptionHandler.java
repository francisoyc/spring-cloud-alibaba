package com.francis.alibaba.handler;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.francis.common.entity.ResultVo;
import com.francis.common.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * sentinel 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 限流后处理方法
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse handleException(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return new SentinelClientHttpResponse(objectMapper.writeValueAsString("Sorry, 被限流了"));
        } catch (JsonProcessingException e) {
            log.error("==========", e);
            return null;
        }
    }

    /**
     * 熔断后处理的方法
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse fallback(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return new SentinelClientHttpResponse(objectMapper.writeValueAsString("Sorry, 被降级了"));
        } catch (JsonProcessingException e) {
            log.error("==========", e);
            return null;
        }
    }

    /**
     * 处理sentinel源码中抛出而未被捕捉的异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BlockException.class)
    public ResultVo handleError(BlockException e) {
        String message = MessageUtils.getErrorMessage(e);
        return new ResultVo(1, message);
    }

}
