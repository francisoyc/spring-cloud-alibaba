package com.francis.alibaba.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.francis.common.entity.ResultVo;
import com.francis.common.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: francis
 * @description: 全局处理 BlockException
 * @date: 2021/1/6 6:58
 */
@Component
@Slf4j
public class FrancisBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, BlockException ex) throws Exception {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        String message = MessageUtils.getErrorMessage(ex);
        response.getOutputStream().write(JSONObject.toJSONString(new ResultVo(1, message)).getBytes());
    }
}
