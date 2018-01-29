package com.huang.tcc.controller;

import com.huang.tcc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created on 2018/1/29 23:37
 *
 * @author <a href="mailto: huangyugui@gomeholdings.com">黄渝贵</a>
 * @version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Map order(){
        orderService.tryOrder(null, "order");
        Map<String, String> map = new HashMap<>();
        map.put("success", "true");
        return map;
    }
}
