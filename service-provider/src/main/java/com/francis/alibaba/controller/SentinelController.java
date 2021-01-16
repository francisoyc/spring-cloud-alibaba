package com.francis.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.francis.common.entity.ResultVo;
import com.francis.common.entity.User;
import com.francis.common.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/15 22:44
 */
@RestController
@RequestMapping(value = "/sentinel/", produces = "application/json;charset=utf-8")
@RefreshScope
public class SentinelController {

    @Value("${user.name:}")
    private String name;

    @Value("${user.age:}")
    private int age;

    /**
     * block 和 fallback 返回类型需和本方法相同，两者都存在时，走 block 方法逻辑
     * @param id
     * @return
     */
    @SentinelResource(value = "/sentinel/user/{id}", blockHandler = "block", fallback = "fallback")
    @GetMapping("user/{id}")
    public ResultVo getUser(@PathVariable int id) {
        return new ResultVo().success(new User(id, age + id, name));
    }

    /**
     * 为每个 SentinelResource 单独指定异常处理方法
     * @param id
     * @param e
     * @return
     */
    public ResultVo block(int id, BlockException e) {
        return new ResultVo().failed(MessageUtils.getErrorMessage(e));
    }

    /**
     * 为每个 SentinelResource 单独指定降级方法
     * @param id
     * @param t
     * @return
     */
    public ResultVo fallback(int id, Throwable t) {
        return new ResultVo().failed(MessageUtils.getErrorMessage(t));
    }
}
