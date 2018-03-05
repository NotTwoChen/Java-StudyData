package com.wsh.interceptor;

import com.wsh.admin.domain.AdminInfo;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ExceptionLogger {

    @Resource
    private HttpServletRequest request;

    @Around("within(com.wsh.*.controller..*)")
    public Object log(ProceedingJoinPoint point) throws  Exception{
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            Logger logger = Logger.getLogger(this.getClass());
            AdminInfo admin = (AdminInfo) request.getSession().getAttribute("admin");
            if (admin != null){
                String className = point.getTarget().getClass().getName();
                String method = point.getSignature().getName();
                String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                StringBuffer sb = new StringBuffer();
                sb.append("用户[").append(admin.getName()).append("],");
                sb.append("IP[").append(request.getRemoteHost()).append("],");
                sb.append("在[").append(date).append("],执行[");
                sb.append(className).append(".").append(method);
                sb.append("]时,发生如下异常:");
                logger.error(sb.toString());
            }
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                logger.error("\t"+stackTraceElement.toString());
            }
            throw new Exception(throwable);
        }
        return object;
    }
}
