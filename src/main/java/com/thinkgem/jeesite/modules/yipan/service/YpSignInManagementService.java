/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpSignInManagementDao;
import com.thinkgem.jeesite.modules.yipan.dto.ServiceResult;
import com.thinkgem.jeesite.modules.yipan.entity.Enums.CardType;
import com.thinkgem.jeesite.modules.yipan.entity.YpBill;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardHolder;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import com.thinkgem.jeesite.modules.yipan.entity.YpSignInManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 打卡记录Service
 *
 * @author zcx
 * @version 2020-05-24
 */
@Service
@Transactional(readOnly = true)
public class YpSignInManagementService extends CrudService<YpSignInManagementDao, YpSignInManagement> {

    @Autowired
    private YpCardHolderService cardHolderService;
    @Autowired
    private YpRockHallService rockHallService;
    @Value("${V10_VPT}")
    private Integer v10_vpt;
    @Value("${V20_VPT}")
    private Integer v20_vpt;
    @Autowired
    private YpMemberService memberService;
    @Autowired
    private YpBillService ypBillService;

    public YpSignInManagement get(String id) {
        return super.get(id);
    }

    public List<YpSignInManagement> findList(YpSignInManagement ypSignInManagement) {
        return super.findList(ypSignInManagement);
    }

    public Page<YpSignInManagement> findPage(Page<YpSignInManagement> page, YpSignInManagement ypSignInManagement) {
        return super.findPage(page, ypSignInManagement);
    }

    @Transactional(readOnly = false)
    public void save(YpSignInManagement ypSignInManagement) {
        super.save(ypSignInManagement);
    }

    @Transactional(readOnly = false)
    public void delete(YpSignInManagement ypSignInManagement) {
        super.delete(ypSignInManagement);
    }

    /**
     * 签到扣费
     *
     * @param openId
     * @param cardNo
     * @param rockNo
     * @return
     */
    @Transactional
    public ServiceResult debit(String openId, String cardNo, String rockNo) {
        //获取卡信息
        YpCardHolder cardHolder = cardHolderService.findByCardNo(cardNo);
        //获取岩馆信息
        YpRockHall rockHall = rockHallService.findByRockNo(rockNo);
        //获取卡类型
        String cardType = cardHolder.getCardType();
        //默认获取岩馆10次卡的单价
        Long price = rockHall.getPriceV10();
        //如果卡类型是20次卡，则获取岩馆20次卡的单价
        int vpt = v10_vpt;
        if (CardType.V20_DIAMOND.name().equalsIgnoreCase(cardType)) {
            price = rockHall.getPriceV20();
            vpt = v20_vpt;
        }
        //默认扣除一次
        long i = 1;
        //当单价大于90时，扣除“单价除以阀值的商”次，如果有余数，则扣除“单价除以阀值的商”+1次
        long beans = 0; //返还易豆数
        if (price > vpt) {
            int outOfRange = price % vpt > 0 ? 1 : 0;
            if (outOfRange > 0) {
                beans = price - price % vpt;
            }
            i = outOfRange + price / vpt;
        }
        Long remainingTimes = cardHolder.getRemainingTimes();
        //当卡次数不足时，直接返回错误信息
        if (remainingTimes <= 0 || remainingTimes < i) {
            return ServiceResult.failure("次数不足，请及时充值");
        }
        //扣除次数，并更新卡信息
        cardHolder.setRemainingTimes(remainingTimes - i);
        cardHolderService.save(cardHolder);
        //补偿易豆
        if (beans > 0) {
            memberService.updateBeansByOpenId(openId, beans);
        }
        //保存签到记录
        save(new YpSignInManagement(cardNo, cardType, openId, cardHolder.getCarduser(), rockNo, rockHall.getRockName(), new Date()));
        //保存流水
        ypBillService.save(new YpBill(cardNo, i + "", price + "", (vpt * i) + "", beans + "", rockNo, vpt == v10_vpt ? CardType.V10_GOLD.name() : CardType.V20_DIAMOND.name()));
        return ServiceResult.success();
    }
}
