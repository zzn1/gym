package com.thinkgem.jeesite.modules.yipan.service;


import com.thinkgem.jeesite.modules.yipan.entity.UnifiedorderResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpUnifiedorder;

import java.util.Map;

public interface YpPayService {

    UnifiedorderResult unifiedorder(YpUnifiedorder ypUnifiedorder);

    Map<String, Object> getOpenId(String code);
}
