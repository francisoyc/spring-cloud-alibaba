package com.francis.alibaba.dao;

import com.francis.alibaba.entity.Order;
import org.apache.ibatis.annotations.*;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/13 7:12
 */
@Mapper
public interface OrderDao {

    @Select("select id, commodity_code as commodityCode, count, money, user_id as userId from order_tbl where id=#{id}")
    Order queryById(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into order_tbl(commodity_code, count, money, user_id) values(#{commodityCode}, #{count}, #{money}, #{userId})")
    int insert(Order order);
}
