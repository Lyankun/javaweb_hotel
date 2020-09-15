package cn.com.Lyankun.ssm.service.impl;

import cn.com.Lyankun.ssm.entity.InRoomInfo;
import cn.com.Lyankun.ssm.service.InRoomInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   入住信息的业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class InRoomInfoServiceImpl extends BaseServiceImpl<InRoomInfo> implements InRoomInfoService {
}
