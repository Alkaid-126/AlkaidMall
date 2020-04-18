package com.alkaid.alkaidmall.order.controller;


import com.Alkaid.AlkaidMall.UserService;
import com.Alkaid.AlkaidMall.bean.UserAddress;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Reference
    private UserService userService;

    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade(String userId){
        return userService.getUserAddressList(userId);
    }
}
