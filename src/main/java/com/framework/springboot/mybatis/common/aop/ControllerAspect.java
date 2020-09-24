package com.framework.springboot.mybatis.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Title: ControllerParamOutAspect
 * @Package: com.framework.springboot.mybatis.common.aop
 * @Author: jiaxiansun
 * @Date: 2020/4/21
 * @Time: 18:29
 * @Description: aop切面拦截controller 打印请求方法、参数、返回值、耗时等
 * @Copyright: jiaxiansun@2020
 */
@Aspect
@Component
public class ControllerAspect {

    private final static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 声明切入点为所有controller下的所有方法
     */
    @Pointcut("execution(* com.framework.springboot.mybatis.module.*.controller.*.*(..))")
    public void Pointcut() {
    }

    @Around("Pointcut()")
    public Object processLog(ProceedingJoinPoint joinPoint) throws Exception {
        JSONObject rqsJson = new JSONObject();
        rqsJson.put("rqsTime", new Date());
        MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());

        Object target = joinPoint.getTarget();
        Class cla = target.getClass();
        String className = cla.getName();
        Method method = cla.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        //获取方法名称

        String methodName = method.getName();
        //获取参数名称
        LocalVariableTableParameterNameDiscoverer paramNames = new LocalVariableTableParameterNameDiscoverer();
        String[] params = paramNames.getParameterNames(method);
        //获取参数
        Object[] args = joinPoint.getArgs();
        //过滤掉request和response,不能序列化
        List<Object> filteredArgs = Arrays.stream(args)
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        rqsJson.put("rqsMethod", methodName);
        if (filteredArgs == null) {
            rqsJson.put("rqsParams", null);
        } else {
            //拼接请求参数
            Map<String, Object> rqsParams = IntStream.range(0, filteredArgs.size())
                    .boxed()
                    .collect(Collectors.toMap(j -> params[j], j -> filteredArgs.get(j)));
            rqsJson.put("rqsParams", rqsParams);
        }
        Object resObj = null;
        long startTime = System.currentTimeMillis();
        try {
            //执行原方法
            resObj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error(methodName + "方法执行异常!", e);
            throw new Exception(e);
        }
        long endTime = System.currentTimeMillis();
        logger.info("{}] [{}] [{}] [{}] [{}] [{}", rqsJson.get("rqsTime"), className, methodName, JSON.toJSONString(rqsJson.get("rqsParams")), JSON.toJSONString(resObj), endTime - startTime);
        return resObj;
    }
}
