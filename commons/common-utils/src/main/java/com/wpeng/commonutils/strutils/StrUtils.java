package com.wpeng.commonutils.strutils;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/18 12:07
 *
 * 判断  封装类
 */
public class StrUtils {


    /**
     * 是否为 null
     */
    public static Boolean isNull(Object T) {

        boolean b = true;

        if (T == null) {
            b = false;
        }
        return b;
    }

}
