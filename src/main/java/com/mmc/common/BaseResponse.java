package com.mmc.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private int responseCode = 200;
    private String message;

    public BaseResponse(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public BaseResponse() {
    }



}
