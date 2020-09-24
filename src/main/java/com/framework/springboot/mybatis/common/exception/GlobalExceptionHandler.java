package com.framework.springboot.mybatis.common.exception;

import com.framework.springboot.mybatis.bean.vo.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: jiaxiansun@dongao.com
 * @Date: 2020/3/13 15:02
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error("异常了", e);
        return R.error("发生了" + e.getClass().getSimpleName() + "异常，异常信息如下：" + e.getMessage());
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}