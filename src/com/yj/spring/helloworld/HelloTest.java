package com.yj.spring.helloworld;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	private Logger logger = Logger.getLogger(HelloTest.class);
	@Test
	public void testHelloWorld() {
		//1、读取配置文件实例化一个IoC容器  
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-helloworld.xml");  
        
        int num = context.getBeanDefinitionCount();
        logger.info("name:"+num);
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”  
        HelloService helloApi = context.getBean("hello", HelloService.class); 
        HelloService helloApi2 = context.getBean("hello2", HelloService.class);
        logger.info("helloApi:"+helloApi+"***");
        logger.info("helloApi:"+helloApi2+"***");
        logger.info("helloApi == helloApi2:"+(helloApi == helloApi2));
        //3、执行业务逻辑  
        helloApi.sayHello("yangjiang");
        helloApi2.sayHello("yangjiang111");
	}

}
