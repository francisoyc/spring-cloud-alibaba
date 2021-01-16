package com.francis.alibaba.controller;

import com.francis.alibaba.service.StorageService;
import com.francis.common.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 23:42
 */
@RestController
@RequestMapping("/seata/")
public class SeataController {
    @Autowired
    private StorageService storageService;

    @PostMapping("storage/decrease")
    public ResultVo decreaseStorage(
            @RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count) {
        return storageService.decreaseStorage(commodityCode, count);
    }
}
