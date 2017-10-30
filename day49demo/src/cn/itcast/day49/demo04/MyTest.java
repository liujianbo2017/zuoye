package cn.itcast.day49.demo04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//仿JUNIT中的@Test
//需要把此注解的生命周期扩展为RUNTIME范围

@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {

	
}
