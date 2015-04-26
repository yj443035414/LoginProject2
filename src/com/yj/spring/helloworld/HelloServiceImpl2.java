package com.yj.spring.helloworld;

import org.apache.log4j.Logger;


public class HelloServiceImpl2 implements HelloService {

	private Logger logger = Logger.getLogger(HelloServiceImpl2.class);
	@Override
	public void sayHello(String name) {
		
		logger.info("HelloServiceImpl2->sayHello:"+name+"Hello World!");
	}

}
