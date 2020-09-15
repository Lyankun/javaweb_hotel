package cn.com.Lyankun.ssm.controller;

import cn.com.Lyankun.ssm.entity.RoomType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   客房类型控制器
 */
@Controller
@RequestMapping("/roomType")
public class RoomTypeController extends BaseController<RoomType> {
}
