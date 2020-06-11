package com.thinkgem.jeesite.modules.yipan.dto;

import com.thinkgem.jeesite.modules.yipan.entity.YpMember;

public class YpMemberDTO extends YpMember {


    private String encryptedData;
    private String iv;


    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
