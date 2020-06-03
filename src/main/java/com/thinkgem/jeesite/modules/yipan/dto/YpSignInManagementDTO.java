package com.thinkgem.jeesite.modules.yipan.dto;

import java.io.Serializable;
import java.util.Date;

public class YpSignInManagementDTO implements Serializable {

    private String cardNo;        // 卡号

    private String rockName;        // 岩馆名称

    private Date signInTime;        // 签到时间

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRockName() {
        return rockName;
    }

    public void setRockName(String rockName) {
        this.rockName = rockName;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }
}
