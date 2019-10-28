package com.alone.golden.controller;

import com.alone.domain.Orders;
import com.alone.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:_AloneBoy
 * @date:2019/10/26
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    //查询所有--使用PageHelper 进行分页处理
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv=new ModelAndView();
        PageInfo pageInfo=new PageInfo(orderService.findAll(page,size));
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    //查询订单详情
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id") String id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("orders",orderService.findById(id));
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
