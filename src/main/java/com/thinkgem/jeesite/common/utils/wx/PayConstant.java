package com.thinkgem.jeesite.common.utils.wx;

/**
 * @ClassName PayConstant
 * @Description TODO
 * @Author TuTu
 * @Date 2020/5/26 18:24
 * @Version 1.0
 */
public class PayConstant {

    //=======【基本信息设置】=====================================
    /**
     *微信公众号身份的唯一标识。审核通过后，在微信发送的邮件中查看
     */
    public static final String APPID = "wx1a9be63c78111ccf";//需改，给客户要
    /**
     *受理商ID，身份标识
     */
    public static final String MCHID = "1585089641";//需改，给客户要
    /**
     *商户支付密钥Key。审核通过后，在微信发送的邮件中查看
     */
    public static final String KEY = "yipankeji12345678910111213141516";//需改，给客户要
    /**
      *JSAPI接口中获取openid，审核后在公众平台开启开发模式后可查看
      */
    public static final String APPSECRET = "0861682173ba56b84a6d0e4895e9676a";//需改，给客户要
    /**
     * 标价币种 默认人民币：CNY
     */
    public static final String FEE_TYPE_DEFAULT = "CNY";

    /**
     * 交易类型 小程序取值如下：JSAPI  APP--app支付
     */
    public static final String TRADE_TYPE_WX_APPLET = "JSAPI";

    public static final String TRADE_TYPE_APP = "APP";

    /**
     * 统一下单调用接口
     */
    public static final String PAY_ORDER_SUCCESS = "SUCCESS";

    public static final String PAY_ORDER_MSG = "OK";

    public static final String PAY_ORDER_FAIL="FAIL";

    /**
     * 支付方式  1:微信  2：支付宝
     */
    public static final Integer PAY_WAY_WX = 1;
    public static final Integer PAY_WAY_ZFB = 2;

    /**
     * 支付结果
     */
    public static final Integer PAY_RESULT_SUCCESS = 1;
    public static final Integer PAY_RESULT_FAIL = 0;//失败

    /**
     * 获取openid
     */
    public static final String WX_GET_OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session";

    /**
     * 下单
     */
    public static final String WX_PAY_BILL_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 微信服务器支付结果回调通知url
     */
    public static String WX_PAY_NOTIFY_URL="http://yipan.club/${adminPath}/yipan/wxpay/notifyUrl";

    /**
     * 订单状态 0：删除 1：已完成 2：未付款  3：待发货 4：待收货 5：待评价 6:已取消
     */
    public static final Integer ORDER_STATUS_DEL = 0;
    public static final Integer ORDER_STATUS_FINISH = 1;
    public static final Integer ORDER_STATUS_NO_PAY = 2;
    public static final Integer ORDER_STATUS_WAIT_DELIVERY = 3;
    public static final Integer ORDER_STATUS_ALREADY_DELIVERY = 4;
    public static final Integer ORDER_STATUS_WAIT_EVALUATION = 5;
    public static final Integer ORDER_STATUS_CANCLE = 6;

}
