package com.alone.dao;

import com.alone.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductDao {

    //根据id查询单个
    @Select("select * from product where id=#{id}")
    public Product findById(String id);

    //查询所有
    @Select("select * from product")
    public List<Product> findAll();

    //保存
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product);
}
