package com.thinkgem.jeesite.modules.yipan.entity.Enums;

/**
 * @ClassName: CardType
 * @Description: TODO
 * @Author: Zhang Zhaonian
 * @date: 2020/5/30 16:13
 */
public enum CardType {
    V10_GOLD("10次卡-黄金会员"),
    V20_DIAMOND("20次卡-钻石会员");
    private String text;

    CardType(String text) {
        this.text = text;
    }

    public static CardType parse(String str) {
        for (CardType value : CardType.values()) {
            if (value.text.equalsIgnoreCase(str) || value.name().equalsIgnoreCase(str)) {
                return value;
            }
        }
        return null;
    }
}
