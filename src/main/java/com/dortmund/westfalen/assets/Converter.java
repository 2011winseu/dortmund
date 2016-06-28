package com.dortmund.westfalen.assets;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by sunmingwei on 16/6/28.
 */
public class Converter {

    public static void tranfer(Object src, Object dest) {
        try {
            Object destination = Class.forName(dest.getClass().getName()).newInstance();
            Class<?> clazz=destination.getClass();

            Field[] destField = clazz.getDeclaredFields();
            for (Field dsfd : destField) {
                dsfd.setAccessible(true);
                for (Field srcfd : src.getClass().getFields()) {
                    srcfd.setAccessible(true);
                    if (StringUtils.equals(srcfd.getName(), dsfd.getName())) {
                        dsfd.set(destination, srcfd.get(src));
                    }
                }
            }
            dest = destination;

        } catch (Exception e) {
            LogTools.logException(e);
        }
    }
}
