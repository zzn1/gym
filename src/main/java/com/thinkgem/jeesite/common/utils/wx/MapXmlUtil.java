package com.thinkgem.jeesite.common.utils.wx;

/**
 * @ClassName MapXmlUtil
 * @Description TODO
 * @Author TuTu
 * @Date 2020/5/26 18:42
 * @Version 1.0
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

public class MapXmlUtil {

    /**
     * Map转换成Xml
     *
     * @param map
     * @return
     */
    public static String map2Xmlstring(Map<String, Object> map) {
        StringBuffer sb = new StringBuffer("");
        sb.append("<xml>");

        Set<String> set = map.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String key = it.next();
            Object value = map.get(key);
            sb.append("<").append(key).append(">");
            sb.append(value);
            sb.append("</").append(key).append(">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * Xml string转换成Map
     *
     * @param xmlStr
     * @return
     */
    public static Map<String, Object> xmlString2Map(String xmlStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc;
        try {
            doc = DocumentHelper.parseText(xmlStr);
            Element el = doc.getRootElement();
            map = recGetXmlElementValue(el, map);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 循环解析xml
     *
     * @param ele
     * @param map
     * @return
     */
    @SuppressWarnings({"unchecked"})
    private static Map<String, Object> recGetXmlElementValue(Element ele, Map<String, Object> map) {
        List<Element> eleList = ele.elements();
        if (eleList.size() == 0) {
            map.put(ele.getName(), ele.getTextTrim());
            return map;
        } else {
            for (Iterator<Element> iter = eleList.iterator(); iter.hasNext(); ) {
                Element innerEle = iter.next();
                recGetXmlElementValue(innerEle, map);
            }
            return map;
        }
    }

    /**
     * xml 转  map
     *
     * @param xml
     * @return
     */
    public static Map<String, String> xmltoMap(String xml) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            Document document = DocumentHelper.parseText(xml);
            Element nodeElement = document.getRootElement();
            List node = nodeElement.elements();
            for (Iterator it = node.iterator(); it.hasNext(); ) {
                Element elm = (Element) it.next();
                String val = elm.getText();
                val = val.replace("<![CDATA[", "");
                val = val.replace("]]>", "");
                map.put(elm.getName(), val);
                elm = null;
            }
            node = null;
            nodeElement = null;
            document = null;
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}