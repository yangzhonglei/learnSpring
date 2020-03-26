package com.yzl.study.logindemo.common;

import com.yzl.study.logindemo.util.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>traceId过滤器,用于设置traceId</P>
 *
 * @author hanchao
 */
@WebFilter(urlPatterns = "/*", filterName = "traceIdFilter")
@Order(1)
@Slf4j
public class TraceIdFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        MDC.put("UUID", UUID.randomUUID().toString().replace("-",""));
        //执行后续过滤器
        filterChain.doFilter(servletRequest,servletResponse);
        MDC.remove("UUID");
    }

}
