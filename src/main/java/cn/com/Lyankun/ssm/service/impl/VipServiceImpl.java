package cn.com.Lyankun.ssm.service.impl;

import cn.com.Lyankun.ssm.entity.Vip;
import cn.com.Lyankun.ssm.service.VipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class VipServiceImpl extends BaseServiceImpl<Vip> implements VipService {
}
