package org.tinygroup.buildinfo.common.util;


import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mr.wang on 2016/6/4.
 */
public class BeanUtil {
    /**
     * 属性拷贝
     * @param dest
     * @param orig
     */
    public static void copyProperties(Object dest, Object orig){
        try {
            BeanUtilsBean.getInstance().copyProperties(dest,orig);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据目标class实例化后
     * @param destClass 目标class
     * @param orig
     * @param <T>
     * @return
     */
    public static  <T> T copyProperties(Class<T> destClass,Object orig){
        if(orig==null) return null;
        try {
            T t = destClass.newInstance();
            copyProperties(t,orig);
            return t;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T getCopiedPropertiesBean(Class<T> destCls, Object orig){
        try {
            T dest = destCls.newInstance();
            copyProperties(dest, orig);
            return dest;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}
