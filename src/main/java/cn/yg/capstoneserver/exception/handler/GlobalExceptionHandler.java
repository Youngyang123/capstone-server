package cn.yg.capstoneserver.exception.handler;

import cn.yg.capstoneserver.exception.BaseUncheckedException;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseUncheckedException.class)
    public ObjectResponseResult<String> baseUncheckedException(BaseUncheckedException exception, HttpServletRequest request) {
        return ObjectResponseResult.getInstance()
                .message(exception.getMessage())
                .success(false)
                .code(exception.getCode());
    }

}
