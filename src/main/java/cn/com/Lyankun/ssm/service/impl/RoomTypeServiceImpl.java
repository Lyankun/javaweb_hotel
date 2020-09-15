package cn.com.Lyankun.ssm.service.impl;

import cn.com.Lyankun.ssm.entity.RoomType;
import cn.com.Lyankun.ssm.service.RoomTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   客房类型业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType> implements RoomTypeService {
}
