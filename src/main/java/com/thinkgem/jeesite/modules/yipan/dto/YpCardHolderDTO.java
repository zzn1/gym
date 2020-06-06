package com.thinkgem.jeesite.modules.yipan.dto;

import com.thinkgem.jeesite.modules.yipan.util.EntityDtoUtil;

import java.io.Serializable;
import java.util.Date;

public class YpCardHolderDTO implements Serializable {

    private String cardNo;		// 卡号

    private String cardType;		// 卡类型

    private String carduser;		// 持卡人姓名

    private Long remainingTimes;		// 剩余次数

    private String beans;		// 易豆

    private String expirationDate;		// 失效日期

    private String buyDate;		// 购卡日期

    public  String getCardNo(){ return  cardNo;}

    public  void setCardNo(String cardNo){ this.cardNo = cardNo;}

    public  String getCardType(){ return  cardType;}

    public  void setCardType(String cardType){ this.cardType = cardType;}

    public String getCarduser() {
        return carduser;
    }

    public void setCarduser(String carduser) {
        this.carduser = carduser;
    }

    public Long getRemainingTimes() {
        return remainingTimes;
    }

    public void setRemainingTimes(Long remainingTimes) {
        this.remainingTimes = remainingTimes;
    }

    public String getBeans() {
        return beans;
    }

    public void setBeans(String beans) {
        this.beans = beans;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = EntityDtoUtil.simpleDateFormat(expirationDate);
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = EntityDtoUtil.simpleDateFormat(buyDate);
    }
}
