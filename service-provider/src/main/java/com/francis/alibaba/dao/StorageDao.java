package com.francis.alibaba.dao;

import com.francis.alibaba.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/13 7:12
 */
@Mapper
public interface StorageDao {

    @Select("select id, commodity_code as commodityCode, count from storage_tbl where commodity_code=#{commodityCode}")
    Storage queryById(@Param("commodityCode") String commodityCode);

    @Update("update storage_tbl set count = count - #{count} where commodity_code=#{commodityCode}")
    int update(Storage storage);
}
