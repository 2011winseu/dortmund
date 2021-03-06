package com.dortmund.westfalen.assets;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mingwei.smw on 2016/4/21.
 */
@Deprecated
public class LogTools {
    private static Logger selfLog = LoggerFactory.getLogger(LogTools.class);

    public static void logException(Exception e) {
        StackTraceElement[] ele = new Throwable().getStackTrace();
        selfLog.error("Clazz:" + getClassName(ele[1].getClassName()) + ",Method:" + ele[1].getMethodName() + ",Line number:" + ele[1].getLineNumber() + ",Exception:", e);
    }

    public static void logError(String message) {
        StackTraceElement[] ele = new Throwable().getStackTrace();
        selfLog.error("Clazz:" + getClassName(ele[1].getClassName()) + ",Method:" + ele[1].getMethodName() + ",Line number:" + ele[1].getLineNumber() + ",ErrorMessage:" + message);
    }

    public static void logException2AssignedFile(Logger assignedLog, Exception e) {
        StackTraceElement[] ele = new Throwable().getStackTrace();
        assignedLog.error("Clazz:" + getClassName(ele[1].getClassName()) + ",Method:" + ele[1].getMethodName() + ",Line number:" + ele[1].getLineNumber() + ",Exception:", e);
    }

    public static void logError2AssignedFile(Logger assignedLog, String message) {
        StackTraceElement[] ele = new Throwable().getStackTrace();
        assignedLog.error("Clazz:" + getClassName(ele[1].getClassName()) + ",Method:" + ele[1].getMethodName() + ",Line number:" + ele[1].getLineNumber() + ",ErrorMessage:" + message);
    }

    private static String getClassName(String clzName) {
        String[] str = StringUtils.split(clzName, ".");
        if (str.length <= 0) {
            return null;
        }
        return str[str.length - 1];
    }
}
