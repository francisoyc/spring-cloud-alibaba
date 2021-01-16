package com.francis.alibaba.service.impl;

import com.francis.alibaba.dao.StorageDao;
import com.francis.alibaba.entity.Storage;
import com.francis.alibaba.service.StorageService;
import com.francis.common.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 0:34
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public ResultVo decreaseStorage(String commodityCode, int count) {
        Storage storage = storageDao.queryById(commodityCode);
        if (storage != null) {
            storage.setCount(count);
            storageDao.update(storage);
            return new ResultVo().success(1);
        }
        return new ResultVo().failed("扣减库存失败");
    }
}
