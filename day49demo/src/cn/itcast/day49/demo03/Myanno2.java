package cn.itcast.day49.demo03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//使用元注解修饰注解,来决定自定义注解的生命周期(有限范围)
//把此注解的生命周期由SOURCE(源码)扩展为RUNTIME(运行时)
@Retention(RetentionPolicy.RUNTIME)
public @interface Myanno2 {

}
