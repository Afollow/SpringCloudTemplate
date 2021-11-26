package cn.chamas.handler;

import cn.chamas.util.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
@ResponseBody
public class NotFoundException {
    @Autowired
    ResultBody resultBody;

    @ExceptionHandler(Exception.class)
    public ResultBody globalException(Exception e){
        resultBody.ready();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            resultBody.setCode(404);
        }else{
            resultBody.setCode(500);
        }
        resultBody.setMsg("Error Message：" + e.getMessage());
        return resultBody;
    }
}
