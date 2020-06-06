package com.thinkgem.jeesite.modules.yipan.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EntityDtoUtil {

    /**
     *
     * 将dto和entity之间的属性互相转换
     *
     */

    public static Object entityTODto(Object src, Object target) {

        Method[] srcMethods = src.getClass().getMethods();

        Method[] targetMethods = target.getClass().getMethods();

        for (Method m : srcMethods) {

            String srcName = m.getName();

            if (srcName.startsWith("get")) {

                try {

                    Object result = m.invoke(src);

                    for (Method mm : targetMethods) {

                        String targetName = mm.getName();

                        if (targetName.startsWith("set")
                                && targetName.substring(3, targetName.length())

                                .equals(srcName.substring(3, srcName.length()))) {

                            mm.invoke(target, result);

                        }

                    }

                } catch (Exception e) {

                }

            }

        }

        return target;

    }

    /**
     *
     * dto集合和实体类集合间的互相属性映射
     *
     */

    @SuppressWarnings("unchecked")
    public static <S, T> List<T> entityTODtoList(List<S> src, List<T> target,
                                              Class<?> targetClass) {

        for (int i = 0; i < src.size(); i++) {

            try {

                Object object = targetClass.newInstance();

                target.add((T) object);

                entityTODto(src.get(i), object);

            } catch (Exception e) {

                continue;// 某个方法反射异常

            }

        }

        return target;

    }


    public static String simpleDateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String time = sdf.format(date);
        return time;
    }
}
