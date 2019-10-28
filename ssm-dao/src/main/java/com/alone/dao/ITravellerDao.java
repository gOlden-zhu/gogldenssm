package com.alone.dao;

import com.alone.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    //根据ID查询
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findById(String id);

}
