package com.alone.service.impl;

import com.alone.dao.IProductDao;
import com.alone.domain.Product;
import com.alone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:_AloneBoy
 * @date:2019/10/25
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    //查询所有商品
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
