package com.axel.custools.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class WebLogAspect {
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切点：拦截所有controller下所有方法
     */
    @Pointcut("execution(public * com.axel.custools.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 请求前记录信息
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 获取请求对象
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletAttr = (ServletRequestAttributes) attributes;
        HttpServletRequest request = servletAttr.getRequest();

        // 打印请求信息
        log.info("==================== 接口请求开始 ====================");
        log.info("请求地址: {}", request.getRequestURL());
        log.info("请求方式: {}", request.getMethod());
        log.info("客户端IP: {}", request.getRemoteAddr());
        log.info("调用类方法: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("请求参数: {}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 请求完成返回结果
     */
    @AfterReturning(returning = "result", pointcut = "webLog()")
    public void doAfterReturning(Object result) {
        long spendTime = System.currentTimeMillis() - startTime.get();
        log.info("接口返回数据: {}", result);
        log.info("接口请求耗时: {} ms", spendTime);
        log.info("==================== 接口请求结束 ====================\n");
        startTime.remove();
    }
}
