package com.dortmund.westfalen.assets;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sunmingwei on 16/7/7.
 */
public class Clazz {

    public static void tranfer(Object src, Object dest) {
        try {
            Class<?> clazz = dest.getClass();
            Field[] destField = clazz.getDeclaredFields();
            Field[] srcField = src.getClass().getDeclaredFields();

            for (Field destElement : destField) {
                destElement.setAccessible(true);
                for (Field srcElement : srcField) {
                    srcElement.setAccessible(true);
                    if (StringUtils.equals(destElement.getName(), srcElement.getName())) {
                        Object value = srcElement.get(src);
                        destElement.set(dest, value);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LogTools.logException(e);
        }
    }

    public static Object getObjectValueByPropertyName(String name, Object object) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, object.getClass());
            Method getter = propertyDescriptor.getReadMethod();
            return getter.invoke(object);
        } catch (Exception e) {
            LogTools.logException(e);
        }
        return null;
    }

}
