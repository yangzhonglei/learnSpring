package com.yzl.study.logindemo.controller;

import com.yzl.study.logindemo.util.ResponseResult;
import com.yzl.study.logindemo.vo.OrderReqVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("/getOrderById")
    public Object getOrderById() {
        OrderReqVO order = new OrderReqVO();
        order.setDesc("订单描述");
        order.setId(666);
        return ResponseResult.successMsgObject(order);
    }


}
