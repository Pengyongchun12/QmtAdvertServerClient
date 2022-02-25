package com.qmt.qmtadvertserverclient.utils.exception;

import cn.dev33.satoken.exception.NotPermissionException;
import com.qmt.qmtadvertserverclient.utils.json.JsonResult;
import com.qmt.qmtadvertserverclient.utils.json.ResultCode;
import com.qmt.qmtadvertserverclient.utils.json.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Logger;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    //public static Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(NotPermissionException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public JsonResult handleBusinessError(NotPermissionException ex) {
        ResultCode resultCode = ResultCode.UNAUTHORIZED;
    //    logger.info("未获得权限");
        return ResultUtil.failure(resultCode);
    }

}
