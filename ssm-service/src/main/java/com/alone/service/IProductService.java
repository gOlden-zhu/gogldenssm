package com.alone.service;

import com.alone.domain.Product;

import java.util.List;

/**
 * @author:_AloneBoy
 * @date:2019/10/24
 * 服务层接口
 */
public interface IProductService {

    //查询单个
    public Product findById(String id);
    //查询所有
    public List<Product> findAll();
    //保存
    public void save(Product product);
}
