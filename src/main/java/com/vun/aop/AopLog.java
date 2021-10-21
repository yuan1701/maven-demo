package com.vun.aop;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auhtor: vun
 * @Description:
 * @Date: Created in 21:46 2021/10/20
 * @Modified By:
 */
@Aspect
@Component
public class AopLog {
    private Logger logger = LoggerFactory.getLogger(AopLog.class);

    private final HttpServletRequest request;

    public AopLog(HttpServletRequest request) {
        this.request = request;
    }


    /**
     * 切入点
     */
    @Pointcut(value = "execution(* com.vun.controller.*.*(..))")
    public void log() {

    }

    /**
     * @param point 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint point) throws JsonProcessingException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuffer sb = new StringBuffer();
        System.out.println("parameterMap:" + parameterMap);
        sb.append("\n【请求 URL】：").append(request.getRequestURL());
        sb.append("\n【请求类名】：").append(point.getSignature().getDeclaringTypeName());
        sb.append("\n【请求方法名】：").append(point.getSignature().getName());
        sb.append("\n【body】：").append(JSONUtil.toJsonStr(point.getArgs()));
        sb.append("\n【请求参数】：").append(JSONUtil.toJsonStr(parameterMap));
        sb.append("\n【请求头Accept】：").append(request.getHeader("Content-Type"));
        sb.append("\n【请求Query】：").append(request.getQueryString());
        System.out.println("sb---" + sb);


        Object[] args = point.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("point.getArgs():"+mapper.writeValueAsString(args));


    }

}
