package com.alone.dao;

import com.alone.domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderDao {

    /*
    * 注解方式多表联合查询
    * 返回封装结果：
    *   一对一：使用 one
    *   一对多：使用 many
    *   @results:注解用来封装结果返回对象封装
    *   @result:用来指定封装的对应字段
    *       id:指定id列
    *       property:指定实体类字段
    *       column:指定表中列名
    *       one:返回的单表数据
    *           select:指定对应的 方法
    *       many:返回的是封装的集合list<E>类型的数据
    * */
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "com.alone.dao.IProductDao.findById"))
    })
    List<Orders> findAll();
}
