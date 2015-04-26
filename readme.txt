此工程在LoginProject工程的基础上，进行了升级

1、如下问题：
当工程中，包含多个servlet时，并且每个servlet中都需要用到某个service对象的时候，对于这种情况
        可以通过在每个servlet中的init方法中，通过如下代码进行对service对象的初始化：
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		loginService = (LoginService)context.getBean(具体bean的名字);
		
       此种方法，虽然可以解决依赖对象的注入问题，但是存在以下问题：
       A、每个servlet中都需要写相似的获取context的代码
       B、具体的bean的名字暴露在servlet中，即：servlet代码中硬编码了应用对象的bean名字
       
       
2、解决思路：
       	1-       将filter或者servlet作为bean定义在applicationContext.xml文件中，和要应用的bean定义放在一起.
       	
       	 	 注：在此工程中，在applicationContext-helloworld.xml配置中，定义了loginServlet及registerServlet 两个bean（同时通过property注入了loginService对象）;
       	 	 
       	2-      实现一个filter代理或者servlet代理，该代理用WebApplicationContext来获得在applicationContext.xml中定义的filter或者servlet的对象，
       		并将任务委托给applicationContext.xml中定义的filter或者servlet
       		
       		 注：在此工程中，通过定义了一个HttpServletProxy类来代理其他servlet,来达到委托、转发的目的。
       		
       	3-      在web.xml中用ContextLoaderListener来初始化spring  的context，同时在filter代理或者servlet代理的定义中用
       		初始化参数来定义applicationContext.xml中filter或者servlet的bean名字（或者直接受用代理的名称获得相应的filter或者servlet的名称）
       		
       		注：在此工程 中，在web.xml中配置的	每个servlet中init-param标签的子标签的<param-value>（参数值）必须与在applicationContext-helloworld.xml中定义
       		          的bean的名字相同（比如：<param-value>loginServlet</param-value> 与 <param-value>registerServlet</param-value>）
       		
       	
       	4-      在web.xml中定义filter代理或者servlet代理的mapping.
       	
       		注：在此工程中，	<servlet-mapping>
								<servlet-name>RegisterProxyServlet</servlet-name>
								<url-pattern>/register</url-pattern>
							</servlet-mapping>
							
							<servlet-mapping>
								<servlet-name>LoginProxyServlet</servlet-name>
								<url-pattern>/login</url-pattern>
							</servlet-mapping>
							
       	
       	
3、总结：
		利用这种方式就将filter或者servlet和业务对象的依赖关系用spring  来进行管理，并且不用在servlet中硬编码要引用的对象名字。