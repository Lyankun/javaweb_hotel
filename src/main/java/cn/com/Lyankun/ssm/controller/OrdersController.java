package cn.com.Lyankun.ssm.controller;

import cn.com.Lyankun.ssm.entity.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController<Orders> {

     //支付成功  1修改订单0--->1    2添加消费记录
@RequestMapping("/afterOrdersPays")
    public String afterOrdersPay(String out_trade_no){
    try {
        return ordersService.afterOrdersPay(out_trade_no);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}

