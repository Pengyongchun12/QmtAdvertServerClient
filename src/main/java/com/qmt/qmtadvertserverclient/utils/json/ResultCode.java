package com.qmt.qmtadvertserverclient.utils.json;

import lombok.Getter;
import lombok.Setter;


@Getter

public enum ResultCode {
    /**
     * 标准成功
     */
    SUCCESS(200, "success"),
    SUCCESS_AND_FAIL(200, "error"),
    SUCCESS_AND_FAIL_CUSTOM(200, "QQ一键登录失败"),
    /**
     * 标准失败
     */
    ERROR(400, "error"),
    UNAUTHORIZED(401,"未获得权限"),
    /*参数错误:1001-1999*/
    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空");
    /*用户错误2001-2999*/


    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public Integer getCode(){
        return code;
    }

}
