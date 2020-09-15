package cn.com.Lyankun.ssm.service.impl;

import cn.com.Lyankun.ssm.service.InRoomInfoService;
import cn.com.Lyankun.ssm.service.RoomSaleService;
import cn.com.Lyankun.ssm.test.InRoomInfoTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class RoomSaleServiceImplTest {
    private final static Logger log = LogManager.getLogger(InRoomInfoTest.class);

    //定义applicationContext对象
    private ApplicationContext applicationContext;

    //定义员工Mapper代理对象
    private RoomSaleService roomSaleService;

    @Before
    public void before(){
        //测试之前读取spring-config.xml文件
        applicationContext = new ClassPathXmlApplicationContext("spring-main.xml");
        //获取员工业务层对象
        roomSaleService = applicationContext.getBean(RoomSaleServiceImpl.class);
    }

    @Test
    public void findRoomSale() {
        try {
            System.out.println(roomSaleService.findRoomSale());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}