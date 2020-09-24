package com.framework.springboot.mybatis.common.filter;

import com.framework.springboot.mybatis.common.utils.HttpRequestUtil;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiaxiansun
 * @PackageName: com.framework.springboot.mybatis.common.filter
 * @CreateTime: 2020-09-23 10:48
 * @Description: BodyReaderFilter
 */
@WebFilter(filterName = "BodyReaderFilter", urlPatterns = "/*")
@Order(1)
public class BodyReaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String contentType = request.getContentType();
            if (contentType.equals(HttpRequestUtil.CONTENTTYPE_JSON)) {
                ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
                filterChain.doFilter(requestWrapper, response);
                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
