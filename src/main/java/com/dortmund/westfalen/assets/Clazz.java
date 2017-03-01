package com.dortmund.westfalen.assets;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
            Smartlog.logException(e);
        }
    }

    @Deprecated
    public static Object listTransfer(Object srcs) {
        List<Object> result = new ArrayList<Object>();
        int index = 0;
        Object bridge = new Object();
        for (Object element : (List<?>)srcs) {




            tranfer(element, bridge);
            result.add(bridge);
        }
        return result;
    }



    public static Object getObjectValueByPropertyName(String name, Object object) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, object.getClass());
            Method getter = propertyDescriptor.getReadMethod();
            return getter.invoke(object);
        } catch (Exception e) {
            Smartlog.logException(e);
        }
        return null;
    }

    public static Boolean setObjectValueByPropertyName(String name, Object object, Object value) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, object.getClass());
            Method writter = propertyDescriptor.getWriteMethod();
            if (writter == null) {
                return false;
            }
            writter.setAccessible(true);
            writter.invoke(object, value);
        } catch (Exception e) {
            Smartlog.logException(e);
            return false;
        }
        return true;
    }



}
