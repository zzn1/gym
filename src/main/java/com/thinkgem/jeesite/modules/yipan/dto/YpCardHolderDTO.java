package com.thinkgem.jeesite.modules.yipan.dto;

import java.io.Serializable;
import java.util.Date;

public class YpCardHolderDTO implements Serializable {

    private String carduser;		// 持卡人姓名

    private Long remainingTimes;		// 剩余次数

    private String beans;		// 易豆

    private Date expirationDate;		// 失效日期

    private Date buyDate;		// 购卡日期

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
