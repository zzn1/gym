package com.thinkgem.jeesite.modules.yipan.service;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.wx.*;
import com.thinkgem.jeesite.modules.yipan.entity.UnifiedorderResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpUnifiedorder;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * @ClassName YpPayServiceImpl
 * @Description TODO
 * @Author TuTu
 * @Date 2020/5/26 14:28
 * @Version 1.0
 */
@Service
public class YpPayServiceImpl implements YpPayService {

    private static Logger logger = Logger.getLogger(YpPayServiceImpl.class);

    @Override
    public UnifiedorderResult unifiedorder(YpUnifiedorder ypUnifiedorder) {

            String appid = PayConstant.APPID;
            logger.info("appid是：" + appid);
            String mch_id = PayConstant.MCHID;
            logger.info("mch_id是：" + mch_id);
            String nonce_str = RandCharsUtils.getRandomString(16);
            String notify_url = PayConstant.WX_PAY_NOTIFY_URL;
            logger.info("notify_url是：" + notify_url);
            String trade_type = "APP";
            //参数：开始生成签名
            SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
            parameters.put("appid", appid);
            parameters.put("mch_id", mch_id);
            parameters.put("nonce_str", nonce_str);
            parameters.put("body", ypUnifiedorder.getBody());
            parameters.put("nonce_str", nonce_str);
            parameters.put("detail", ypUnifiedorder.getDetail());
            parameters.put("attach", ypUnifiedorder.getAttach());
            parameters.put("out_trade_no", ypUnifiedorder.getOut_trade_no());
            parameters.put("total_fee", ypUnifiedorder.getTotal_fee());
            parameters.put("time_start", RandCharsUtils.timeStart());
            parameters.put("time_expire", RandCharsUtils.timeExpire());
            parameters.put("notify_url", notify_url);
            parameters.put("trade_type", trade_type);
            parameters.put("spbill_create_ip", ypUnifiedorder.getSpbill_create_ip());

            //生成签名
            String sign = WXSignUtils.createSign("UTF-8", parameters);
            logger.info(sign);

            //统一下单
            ypUnifiedorder.setAppid(appid);
            ypUnifiedorder.setMch_id(mch_id);
            ypUnifiedorder.setNonce_str(nonce_str);
            ypUnifiedorder.setSign(sign);
            ypUnifiedorder.setTime_start(RandCharsUtils.timeStart());
            ypUnifiedorder.setTime_expire(RandCharsUtils.timeExpire());
            ypUnifiedorder.setNotify_url(notify_url);
            ypUnifiedorder.setTrade_type(trade_type);
            //构造xml参数
            String xmlInfo = HttpXmlUtils.xmlInfo(ypUnifiedorder);

            String wxUrl = PayConstant.WX_PAY_BILL_URL;

            String method = "POST";

            String weixinPost = HttpXmlUtils.httpsRequest(wxUrl, method, xmlInfo).toString();
            UnifiedorderResult result = ParseXMLUtils.jdomParseXml(weixinPost);
            //二次加签
            if (result.getResult_code().equals("SUCCESS")) {
                long currentTimeMillis = System.currentTimeMillis();//生成时间戳
                long second = currentTimeMillis / 1000L;//（转换成秒）
                String seconds = String.valueOf(second).substring(0, 10);//（截取前10位）

                SortedMap<Object, Object> signParam = new TreeMap<Object, Object>();
                signParam.put("appid", result.getAppid());//app_id
                signParam.put("partnerid", result.getMch_id());//微信商户账号
                signParam.put("prepayid", result.getPrepay_id());//预付订单id
                signParam.put("package", "Sign=WXPay");//默认sign=WXPay
                signParam.put("noncestr", result.getNonce_str());//自定义不重复的长度不长于32位
                signParam.put("timestamp", seconds);//北京时间时间戳


                String signAgain = WXSignUtils.createSign("UTF-8", signParam);
                result.setSign(signAgain);
                result.setTimestamp(seconds);
                result.setPackageValue("Sign=WXPay");
            }
            return result;
    }


    @Override
    public Map<String, Object> getOpenId(String code) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("status", 0);//默认失败
            map.put("appId", PayConstant.APPID);
            //根据code获取openid(用户进入微信公众号即可获得code,前台直接传过来)
            if (!StringUtils.isNotBlank(code)) {//有code   String access_token_url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
                HttpClientUtil httpClientUtil = new HttpClientUtil();
                String access_token_url = PayConstant.WX_GET_OPENID_URL + "?appid=" + PayConstant.APPID + "&secret=" + PayConstant.APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
                String response = httpClientUtil.doGet(access_token_url, null);
                JSONObject jsonObj = JSONObject.parseObject(response);
                if (null != jsonObj) {
                    map.put("status", 1);
                    map.put("openid", jsonObj.getString("openid"));
                    //TODO  把openid 存入缓存
                }
                return jsonObj;
            } else {
                return (Map) new HashMap<String, Object>().put("0", "没有传入code值");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return (Map) new HashMap<String, Object>().put("-1", "系统异常");
        }
    }

}
