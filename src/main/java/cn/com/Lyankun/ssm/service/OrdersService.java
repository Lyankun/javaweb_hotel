package cn.com.Lyankun.ssm.service;

import cn.com.Lyankun.ssm.entity.Orders;

public interface OrdersService extends BaseService<Orders>{


//支付成功后根据订单编号操作结果
String afterOrdersPay(String orderNum)throws Exception;
}
