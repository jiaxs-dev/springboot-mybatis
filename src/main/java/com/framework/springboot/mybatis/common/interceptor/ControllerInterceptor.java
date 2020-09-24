package com.framework.springboot.mybatis.common.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiaxiansun
 * @PackageName: com.dongao.dio.mquery.common.interceptor
 * @CreateTime: 2020-09-11 10:21
 * @Description: 拦截器实现
 */
@Component
public class ControllerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
        /*if (null != requestParam.getString("token") && !"".equals(requestParam.getString("token"))) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            out = response.getWriter();
            out.write(JSON.toJSONString(R.error(307, "访问未授权")));
            out.flush();
            out.close();
            return false;
        }*/
    }
}
