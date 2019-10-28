package com.alone.service;

import com.alone.domain.Orders;

import java.util.List;

public interface IOrderService {
    //查询所有
    List<Orders> findAll(int page,int size);
    //订单详情
    Orders findById(String id);
}
