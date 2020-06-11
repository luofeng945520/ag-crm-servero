package com.cn.ag.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {

    public static Field[] fieldsOf(Object anyObject){
        return anyObject.getClass().getDeclaredFields();
    }

    public static Field[] retainFields(List<String> fieldNames,Field[] fields){
        return Arrays.stream(fields).filter(field -> fieldNames.contains(field.getName())).toArray(Field[]::new);
    }

}
