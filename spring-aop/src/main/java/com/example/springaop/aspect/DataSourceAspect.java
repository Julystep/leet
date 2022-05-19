package com.example.springaop.aspect;

import com.example.springaop.anno.DataSourceAnno;
import com.example.springaop.config.DynamicDataSourceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: liml
 * @date: 2022/5/18
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.example.springaop.anno.DataSourceAnno) || @within(com.example.springaop.anno.DataSourceAnno)")
    public void postCut() {

    }

    @Around("postCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        DataSourceAnno dataSource = getDataSource(joinPoint);
        if (Objects.nonNull(dataSource)) {
            DynamicDataSourceContext.setDataSourceType(dataSource.dataSourceName());
        }
        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceContext.clearDataSourceType();
        }
    }


    public DataSourceAnno getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSourceAnno dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSourceAnno.class);
        if (Objects.nonNull(dataSource)) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSourceAnno.class);
    }

}
