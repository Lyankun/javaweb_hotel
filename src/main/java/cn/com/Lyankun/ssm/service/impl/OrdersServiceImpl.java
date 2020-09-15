package cn.com.Lyankun.ssm.service.impl;

import cn.com.Lyankun.ssm.entity.InRoomInfo;
import cn.com.Lyankun.ssm.entity.Orders;
import cn.com.Lyankun.ssm.entity.RoomSale;
import cn.com.Lyankun.ssm.entity.Rooms;
import cn.com.Lyankun.ssm.service.OrdersService;
import cn.com.Lyankun.ssm.utils.DateUitls;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService {
    //订单添加的同时要完成如下操作
    //1.生成订单数据(以订单的添加为主)
    //2.入住信息是否退房的状态的修改（未退房-->已退房）
    //3.客房的状态修改（已入住-->打扫）
    //要不全部成功，要不全部失败，所以必须控制在一个业务层事物中
    //重写父类的添加的方法

    
    @Override
    public String save(Orders orders) throws Exception {
        //1.生成订单数据(以订单的添加为主)
        int insOrdersCount = baseMapper.insert(orders);//此时的baseMapper对象中的泛型T为Orders
        //2.入住信息是否退房的状态的修改（未退房-->已退房）
        //2.1新建要被修改的入住信息对象
        InRoomInfo inRoomInfo = new InRoomInfo();
        //2.2往要被修改的入住信息中设置值
        inRoomInfo.setId(orders.getIriId());
        inRoomInfo.setOutRoomStatus("1");
        //2.3执行入住信息的修改
        int updInRoomInfoCount = inRoomInfoMapper.updateByPrimaryKeySelective(inRoomInfo);
        //自定义异常
        // int i = 1/0;  //除数为0的异常，代码到此处停止下来就不会继续向下执行
        //3.客房的状态修改（已入住-->打扫） 1---->2
        //3.1根据入住信息id查询出入住信息
        InRoomInfo selInRoomInfo = inRoomInfoMapper.selectByPrimaryKey(orders.getIriId());
        //3.2新建客房对象
        Rooms rooms = new Rooms();
        //3.3往要被修改的客房信息中设置值
        rooms.setId(selInRoomInfo.getRoomId());
        rooms.setRoomStatus("2");
        int updRoomsCount = roomsMapper.updateByPrimaryKeySelective(rooms);
        if(insOrdersCount>0&&updInRoomInfoCount>0&&updRoomsCount>0){
            return "success";
        }else {
            return "fail";
        }
    }
    //支付成功后根据订单编号操作结果
    @Override
    public String afterOrdersPay(String orderNum) throws Exception {
        //1根据订单编号查询
        Orders praOrders=new Orders();
        praOrders.setOrderNum(orderNum);

        Orders orders = baseMapper.selectOneByPramas(praOrders);

        //支付成功  1修改订单0--->1    2添加消费记录
        Orders updOrder=new Orders();
        updOrder.setId(orders.getId());
        updOrder.setOrderStatus("1");

        int updOrderCount = baseMapper.updateByPrimaryKeySelective(updOrder);
        //执行添加
        RoomSale roomSale=new RoomSale();
        String[] ordersOthers=orders.getOrderOther().split(",");
        roomSale.setRoomNum(ordersOthers[0]);
        roomSale.setCustomerName(ordersOthers[1]);
        roomSale.setStartDate(DateUitls.strDate(ordersOthers[2]));
        roomSale.setEndDate(DateUitls.strDate(ordersOthers[3]));
        roomSale.setDays(Integer.valueOf(ordersOthers[4]));
        String[] ordersPrice=orders.getOrderPrice().split(",");
        //客房单价
        roomSale.setRoomPrice(Double.valueOf(ordersPrice[0]));
        //其他消费
        roomSale.setOtherPrice(Double.valueOf(ordersPrice[1]));
        //实际住房金额
        roomSale.setRentPrice(Double.valueOf(ordersPrice[2]));
        //订单实际支付金额
        roomSale.setSalePrice(orders.getOrderMoney());
        //优惠金额
        Double discountPrice = roomSale.getRoomPrice()*roomSale.getDays()-roomSale.getRentPrice();
        roomSale.setDiscountPrice(discountPrice);
        //执行添加
        int insRoomSaleCount= roomSaleMapper.insert(roomSale);

        if(updOrderCount>0&&insRoomSaleCount>0){
            return "redirect:/model/toIndex";
        }else {
            return "redirect:/model/toErrorPay";  //重定向到异常页
        }
    }
}

