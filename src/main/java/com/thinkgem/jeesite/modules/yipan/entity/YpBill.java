/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 流水记账Entity
 *
 * @author zcx
 * @version 2020-05-24
 */
public class YpBill extends DataEntity<YpBill> {

    private static final long serialVersionUID = 1L;
    private String cardNo;        // 卡号
    private String signInNum;        // 扣卡次数
    private String originalPrice;        // 原价
    private String deductionPrice;        // 实际扣费价格
    private String beansNum;        // 易豆补偿数量
    private String rockNo;        // 岩馆编号
    private String deductionType;        // 扣费类型

    public YpBill() {
        super();
    }

    public YpBill(String id) {
        super(id);
    }

    @Length(min = 0, max = 255, message = "卡号长度必须介于 0 和 255 之间")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Length(min = 0, max = 255, message = "扣卡次数长度必须介于 0 和 255 之间")
    public String getSignInNum() {
        return signInNum;
    }

    public void setSignInNum(String signInNum) {
        this.signInNum = signInNum;
    }

    @Length(min = 0, max = 255, message = "原价长度必须介于 0 和 255 之间")
    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Length(min = 0, max = 255, message = "实际扣费价格长度必须介于 0 和 255 之间")
    public String getDeductionPrice() {
        return deductionPrice;
    }

    public void setDeductionPrice(String deductionPrice) {
        this.deductionPrice = deductionPrice;
    }

    @Length(min = 0, max = 255, message = "易豆补偿数量长度必须介于 0 和 255 之间")
    public String getBeansNum() {
        return beansNum;
    }

    public void setBeansNum(String beansNum) {
        this.beansNum = beansNum;
    }

    @Length(min = 0, max = 255, message = "岩馆编号长度必须介于 0 和 255 之间")
    public String getRockNo() {
        return rockNo;
    }

    public void setRockNo(String rockNo) {
        this.rockNo = rockNo;
    }

    @Length(min = 0, max = 255, message = "扣费类型长度必须介于 0 和 255 之间")
    public String getDeductionType() {
        return deductionType;
    }

    public void setDeductionType(String deductionType) {
        this.deductionType = deductionType;
    }

}
