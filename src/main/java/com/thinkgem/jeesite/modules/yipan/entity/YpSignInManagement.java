/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 打卡记录Entity
 *
 * @author zcx
 * @version 2020-05-24
 */
public class YpSignInManagement extends DataEntity<YpSignInManagement> {

    private static final long serialVersionUID = 1L;
    private String cardNo;        // 卡号
    private String cardType;        // 卡类型
    private String openid;        // 持卡人id
    private String carduser;        // 持卡人姓名
    private String rockNo;        // 岩馆编号
    private String rockName;        // 岩馆名称
    private Date signInTime;        // 签到时间

    public YpSignInManagement() {
        super();
    }

    public YpSignInManagement(String cardNo, String cardType, String openid, String carduser, String rockNo, String rockName, Date signInTime) {
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.openid = openid;
        this.carduser = carduser;
        this.rockNo = rockNo;
        this.rockName = rockName;
        this.signInTime = signInTime;
    }

    public YpSignInManagement(String id) {
        super(id);
    }

    @Length(min = 0, max = 255, message = "卡号长度必须介于 0 和 255 之间")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Length(min = 0, max = 255, message = "卡类型长度必须介于 0 和 255 之间")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Length(min = 0, max = 255, message = "持卡人id长度必须介于 0 和 255 之间")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Length(min = 0, max = 255, message = "持卡人姓名长度必须介于 0 和 255 之间")
    public String getCarduser() {
        return carduser;
    }

    public void setCarduser(String carduser) {
        this.carduser = carduser;
    }

    @Length(min = 0, max = 255, message = "岩馆编号长度必须介于 0 和 255 之间")
    public String getRockNo() {
        return rockNo;
    }

    public void setRockNo(String rockNo) {
        this.rockNo = rockNo;
    }

    @Length(min = 0, max = 255, message = "岩馆名称长度必须介于 0 和 255 之间")
    public String getRockName() {
        return rockName;
    }

    public void setRockName(String rockName) {
        this.rockName = rockName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

}
