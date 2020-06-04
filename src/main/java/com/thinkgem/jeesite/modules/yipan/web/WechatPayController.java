package com.thinkgem.jeesite.modules.yipan.web;

import com.thinkgem.jeesite.common.utils.wx.MapXmlUtil;
import com.thinkgem.jeesite.modules.yipan.entity.UnifiedorderResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpUnifiedorder;
import com.thinkgem.jeesite.modules.yipan.service.YpBillService;
import com.thinkgem.jeesite.modules.yipan.service.YpPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WechatPayController
 * @Description 微信支付
 * @Author TuTu
 * @Date 2020/5/26 11:35
 * @Version 1.0
 */
@RestController
@RequestMapping("value = ${adminPath}/yipan/wxpay")
public class WechatPayController {
    @Resource
    private YpPayService ypPayService;
    @Autowired
    private YpBillService ypBillService;

    /* 获取openId
	 * @param code
	 * @return
     */
    @RequestMapping("/getOpenId")
    public Map<String, Object> getOpenId(@RequestParam("code") String code){
        return ypPayService.getOpenId(code);
    }

    /**
     * 统一下单
     * @param  ypUnifiedorder  统一下单提交为微信的参数
     * @return
     */
    @RequestMapping("/unifiedorder")
    @ResponseBody
    public UnifiedorderResult Unifiedorder(@RequestBody YpUnifiedorder ypUnifiedorder) {
        return ypPayService.unifiedorder(ypUnifiedorder);
    }

    /**
     *
     * 回调方法   此处作业务逻辑处理，到此处说明已支付成功，在这块需要改变订单状态等逻辑处理的信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/notifyUrl")
    public String notifyUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resXml="";
        String xmlBack="";
        System.err.println("进入异步通知");
        InputStream is = request.getInputStream();
        //将InputStream转换成String
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        resXml=sb.toString();
        System.err.println(resXml);
        Map<String, String> notifyMap = new HashMap<String, String>();
        try {
            notifyMap = MapXmlUtil.xmltoMap(resXml);
            String  return_code = notifyMap.get("return_code");//状态
            String out_trade_no = notifyMap.get("out_trade_no");//订单号
            if("SUCCESS".equals(return_code)){
                //TODO 处理自己的业务逻辑  比如修改订单状态

                xmlBack = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }else {
                xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }
        } catch (Exception e) {
        }
        return xmlBack;
    }

}
