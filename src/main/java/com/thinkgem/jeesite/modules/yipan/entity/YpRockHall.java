/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 岩馆管理Entity
 *
 * @author zcx
 * @version 2020-05-24
 */
public class YpRockHall extends DataEntity<YpRockHall> {

    private static final long serialVersionUID = 1L;
    private String rockNo;        // 岩馆编号
    private String region;        // 地区
    private String rockName;        // 岩馆名称
    private String add;        // 地址
    private String priceV10;        // 10次卡价格
    private String priceV20;        // 20次卡价格
    private String status;        // 状态
    private String type;        // 岩馆类型

    public YpRockHall() {
        super();
    }

    public YpRockHall(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "岩馆编号长度必须介于 0 和 64 之间")
    public String getRockNo() {
        return rockNo;
    }

    public void setRockNo(String rockNo) {
        this.rockNo = rockNo;
    }

    @Length(min = 0, max = 255, message = "地区长度必须介于 0 和 255 之间")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Length(min = 0, max = 255, message = "岩馆名称长度必须介于 0 和 255 之间")
    public String getRockName() {
        return rockName;
    }

    public void setRockName(String rockName) {
        this.rockName = rockName;
    }

    @Length(min = 0, max = 255, message = "地址长度必须介于 0 和 255 之间")
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Length(min = 0, max = 255, message = "10次卡价格长度必须介于 0 和 255 之间")
    public String getPriceV10() {
        return priceV10;
    }

    public void setPriceV10(String priceV10) {
        this.priceV10 = priceV10;
    }

    @Length(min = 0, max = 255, message = "20次卡价格长度必须介于 0 和 255 之间")
    public String getPriceV20() {
        return priceV20;
    }

    public void setPriceV20(String priceV20) {
        this.priceV20 = priceV20;
    }

    @Length(min = 0, max = 255, message = "状态长度必须介于 0 和 255 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Length(min = 0, max = 255, message = "岩馆类型长度必须介于 0 和 255 之间")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
