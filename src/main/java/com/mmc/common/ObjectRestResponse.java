package com.mmc.common;

public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    String apiVersion;

    public static ObjectRestResponse data(Object data) {
        ObjectRestResponse objectRestResponse=new ObjectRestResponse();
        objectRestResponse.setData(data);
        return objectRestResponse;
    }

    public static ObjectRestResponse success() {
        ObjectRestResponse objectRestResponse=new ObjectRestResponse();
        return objectRestResponse;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}