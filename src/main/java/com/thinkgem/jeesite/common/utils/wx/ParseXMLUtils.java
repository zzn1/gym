package com.thinkgem.jeesite.common.utils.wx;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.modules.yipan.entity.UnifiedorderResult;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * @ClassName ParseXMLUtils
 * @Description TODO
 * @Author TuTu
 * @Date 2020/5/27 17:11
 * @Version 1.0
 */
public class ParseXMLUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
      * objectToJson
      * @param data
      */
    public static String objectToJson(Object data) throws IOException {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch ( IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * JDOM解析XML
     * 解析的时候自动去掉CDMA
     * @param xml
     */
    @SuppressWarnings("unchecked")
    public static UnifiedorderResult jdomParseXml(String xml){
        try {
            StringReader read = new StringReader(xml);
            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);
            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // 通过输入源构造一个Document
            org.jdom.Document doc;
            doc = (org.jdom.Document) sb.build(source);

            org.jdom.Element root = doc.getRootElement();// 指向根节点
            List<org.jdom.Element> list = root.getChildren();
            UnifiedorderResult result = new UnifiedorderResult();
            Field[] fields = result .getClass().getDeclaredFields();
            if(list!=null&&list.size()>0){
                for (org.jdom.Element element : list) {
                    System.out.println("key是："+element.getName()+"，值是："+element.getText());
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if(field.getName().equals(element.getName())){
                            field.set(result,element.getText());
                        }
                    }

                }
            }
            System.out.println(objectToJson(result));
            return result;
        } catch (JDOMException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
