package com.yj.spring.helloworld;

import org.apache.log4j.Logger;


public class HelloServiceImpl implements HelloService {

	private Logger logger = Logger.getLogger(HelloServiceImpl.class);
	@Override
	public void sayHello(String name) {
		
		logger.info("HelloServiceImpl->sayHello:"+name+"Hello World!");
	}

}
