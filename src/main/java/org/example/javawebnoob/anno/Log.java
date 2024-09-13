package org.example.javawebnoob.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//这个注解在被运行时环境生效
@Target(ElementType.METHOD)//这个注解只能用于方法上
public @interface Log {
}
