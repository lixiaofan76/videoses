package com.qfedu.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

// 全局的异常处理类
// 控制器的增强
@ControllerAdvice  // 该注解也需要扫描
@ResponseBody  // 修饰类，类中的所有方法，相当于都使用该注解修饰
public class CommonException {

    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
    public JsonResult constraintViolationException(ConstraintViolationException ex){
        // 验证不通过的信息
        Iterator<ConstraintViolation<?>>
                iterator = ex.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println(message);
        }
        return new JsonResult(0, "验证异常");
    }

    // 处理那些没有预料到的异常
    @ExceptionHandler
//    @ResponseBody
    public JsonResult commonException(Exception ex){
        return new JsonResult(0, ex.getMessage());
    }

}
