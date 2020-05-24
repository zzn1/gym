/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 会员管理Entity
 *
 * @author zcx
 * @version 2020-05-24
 */
public class YpMember extends DataEntity<YpMember> {

    private static final long serialVersionUID = 1L;
    private String openid;        // 微信登录，唯一账户id
    private String carduser;        // 姓名
    private String sex;        // 性别
    private String age;        // 年龄
    private String phone;        // 手机号
    private String idcard;        // 身份证号
    private String creatBy;        // 创建者

    public YpMember() {
        super();
    }

    public YpMember(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "微信登录，唯一账户id长度必须介于 0 和 64 之间")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Length(min = 0, max = 255, message = "姓名长度必须介于 0 和 255 之间")
    public String getCarduser() {
        return carduser;
    }

    public void setCarduser(String carduser) {
        this.carduser = carduser;
    }

    @Length(min = 0, max = 255, message = "性别长度必须介于 0 和 255 之间")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Length(min = 0, max = 2, message = "年龄长度必须介于 0 和 2 之间")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Length(min = 0, max = 12, message = "手机号长度必须介于 0 和 12 之间")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min = 0, max = 255, message = "身份证号长度必须介于 0 和 255 之间")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Length(min = 1, max = 64, message = "创建者长度必须介于 1 和 64 之间")
    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

}
