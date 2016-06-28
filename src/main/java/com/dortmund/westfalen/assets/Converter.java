package com.dortmund.westfalen.assets;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Field;

/**
 * Created by sunmingwei on 16/6/28.
 */
public class Converter {

    public static void tranfer(Object src, Object dest) {
        try {
            Object destination = Class.forName(dest.getClass().getName()).newInstance();
            Class<?> clazz = destination.getClass();
            Field[] destField = clazz.getDeclaredFields();
            Field[] srcField = src.getClass().getDeclaredFields();

            for (Field dsfd : destField) {
                dsfd.setAccessible(true);
                for (Field srcfd : srcField) {
                    srcfd.setAccessible(true);
                    if (StringUtils.equals(dsfd.getName(), srcfd.getName())) {
                        System.out.println(ToStringBuilder.reflectionToString(srcfd.get(src)));
                        dsfd.set(destination, srcfd.get(src));
                        break;
                    }
                }
            }
            dest = destination;

        } catch (Exception e) {
            LogTools.logException(e);
        }
    }
}
