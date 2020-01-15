package com.mmc.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

/**
 * @description: 实体类操作工具
 * @author: mmc
 * @create: 2019-09-06 16:06
 **/

public class EntityUtils {

    private final static String ID="id";

    private final static String CRT_TIME="createTime";

    private final static String UPD_TIME="updateTime";

    public static <T> void setCreateInfo(T entity){
        if(!isPKNotNull(entity,ID)){
            try {
                //只对String类型的id进行赋值
                Field field = entity.getClass().getDeclaredField(ID);
                if(field.getType().equals(String.class)){
                    setPK(entity,ID);
                }
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }

        }
        setDefaultValue(entity,CRT_TIME,new Date());
    }


    public static <T> void setUpdatedInfo(T entity){
        setDefaultValue(entity,UPD_TIME,new Date());
    }

    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
        for(int i=0;i<fields.length;i++){
            String field = fields[i];
            if(ReflectionUtils.hasField(entity, field)){
                ReflectionUtils.invokeSetter(entity, field, value[i]);
            }
        }
    }

    private static <T> void setDefaultValue(T entity, String field, Object value) {
            if(ReflectionUtils.hasField(entity, field)){
                ReflectionUtils.invokeSetter(entity, field, value);
            }
    }

    /**
     * 设置主键
     * @param entity
     * @param PK
     * @param <T>
     */
    private static <T> void setPK(T entity,String PK){
        ReflectionUtils.invokeSetter(entity, PK, UUID.randomUUID().toString());
    }

    /**
     * 根据主键属性，判断主键是否值为空
     * @param entity
     * @param field
     * @param <T>
     * @return 键为空，则返回false；主键有值，返回true
     */
    public static <T> boolean isPKNotNull(T entity,String field){
        if(!ReflectionUtils.hasField(entity, field)) {
            return false;
        }
        Object value = ReflectionUtils.getFieldValue(entity, field);
        return value!=null&&!"".equals(value);
    }
}
