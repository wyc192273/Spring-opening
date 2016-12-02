package com.vilo.util;

import com.google.common.collect.Lists;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Copyright (c) 2016 Qunar.com. All Rights Reserved
 *
 * @author yuchen.wu
 * @date 16-11-29.
 */

public class MapToObject {

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {



        String json = "[{\"fieldName\":{\"type\":\"EVENTPROPERTY\",\"name\":\"userId\",\"null_value\":\"false\",\"property\":\"STRING\"},\"alg\":\"=\",\"parameter\":{\"type\":\"NORMAL\",\"value\":\"123\",\"null_value\":\"false\"},\"isCaseSensitive\":\"0\",\"code\":\"A\"},{\"fieldName\":{\"type\":\"EVENTPROPERTY\",\"name\":\"ucEmail\",\"null_value\":\"false\",\"property\":\"STRING\"},\"alg\":\"=\",\"parameter\":{\"type\":\"NORMAL\",\"value\":\"123@qq.com\",\"null_value\":\"false\"},\"isCaseSensitive\":\"0\",\"code\":\"B\"}]";

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,Object>> list = mapper.readValue(json, List.class);
        Condition condition = (Condition) mapToObject(list.get(0),Condition.class);
//        Condition condition = mapper.convertValue(list, Condition.class);
        System.out.println();
    }

    public static Object mapToObject(Map<String,Object> map , Class<?> beanClass)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }

            field.setAccessible(true);
            System.out.println(field.getClass());
            if(field.getGenericType().toString().equals("int")||field.getGenericType().toString().equals("double")||field.getGenericType().equals("long")){
                field.set(obj, Integer.parseInt(map.get(field.getName()).toString()));
                continue;
            }
            String className = field.getGenericType().toString().substring(6);
            if(!className.equals("java.lang.String")){
                field.set(obj, mapToObject((Map<String, Object>) map.get(field.getName()), Class.forName(className)));
            }else{
                field.set(obj, map.get(field.getName()));
            }

        }

        return obj;

    }

}

class A{
    private int a;
    private String b;
    private List<String> str;
    private List<B> bList;

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }

    public List<String> getStr() {
        return str;
    }

    public void setStr(List<String> str) {
        this.str = str;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}

class B{
    String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
