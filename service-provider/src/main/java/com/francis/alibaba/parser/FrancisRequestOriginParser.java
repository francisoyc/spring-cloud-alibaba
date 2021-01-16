package com.francis.alibaba.parser;

import org.springframework.stereotype.Component;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: francis
 * @description: sentinel 授权规则解析origin，请求头中需要传 app 属性
 * @date: 2021/1/9 15:33
 */
@Component
public class FrancisRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("app");
        if (StringUtils.isEmpty(origin)) {
            throw new IllegalArgumentException("attribute app in request head must not be null");
        }
        return origin;
    }
}
