package com.francis.alibaba.service;

import com.francis.common.entity.ResultVo;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 0:33
 */
public interface StorageService {

    ResultVo decreaseStorage(String commodityCode, int count);
}
