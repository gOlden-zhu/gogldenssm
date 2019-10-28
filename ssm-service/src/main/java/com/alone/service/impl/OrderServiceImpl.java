package com.alone.service.impl;

import com.alone.dao.IOrderDao;
import com.alone.domain.Orders;
import com.alone.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:_AloneBoy
 * @date:2019/10/26
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderDao iOrderDao;


    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return iOrderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return iOrderDao.findById(id);
    }
}
