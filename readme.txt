�˹�����LoginProject���̵Ļ����ϣ�����������

1���������⣺
�������У��������servletʱ������ÿ��servlet�ж���Ҫ�õ�ĳ��service�����ʱ�򣬶����������
        ����ͨ����ÿ��servlet�е�init�����У�ͨ�����´�����ж�service����ĳ�ʼ����
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		loginService = (LoginService)context.getBean(����bean������);
		
       ���ַ�������Ȼ���Խ�����������ע�����⣬���Ǵ����������⣺
       A��ÿ��servlet�ж���Ҫд���ƵĻ�ȡcontext�Ĵ���
       B�������bean�����ֱ�¶��servlet�У�����servlet������Ӳ������Ӧ�ö����bean����
       
       
2�����˼·��
       	1-       ��filter����servlet��Ϊbean������applicationContext.xml�ļ��У���ҪӦ�õ�bean�������һ��.
       	
       	 	 ע���ڴ˹����У���applicationContext-helloworld.xml�����У�������loginServlet��registerServlet ����bean��ͬʱͨ��propertyע����loginService����;
       	 	 
       	2-      ʵ��һ��filter�������servlet�����ô�����WebApplicationContext�������applicationContext.xml�ж����filter����servlet�Ķ���
       		��������ί�и�applicationContext.xml�ж����filter����servlet
       		
       		 ע���ڴ˹����У�ͨ��������һ��HttpServletProxy������������servlet,���ﵽί�С�ת����Ŀ�ġ�
       		
       	3-      ��web.xml����ContextLoaderListener����ʼ��spring  ��context��ͬʱ��filter�������servlet����Ķ�������
       		��ʼ������������applicationContext.xml��filter����servlet��bean���֣�����ֱ�����ô�������ƻ����Ӧ��filter����servlet�����ƣ�
       		
       		ע���ڴ˹��� �У���web.xml�����õ�	ÿ��servlet��init-param��ǩ���ӱ�ǩ��<param-value>������ֵ����������applicationContext-helloworld.xml�ж���
       		          ��bean��������ͬ�����磺<param-value>loginServlet</param-value> �� <param-value>registerServlet</param-value>��
       		
       	
       	4-      ��web.xml�ж���filter�������servlet�����mapping.
       	
       		ע���ڴ˹����У�	<servlet-mapping>
								<servlet-name>RegisterProxyServlet</servlet-name>
								<url-pattern>/register</url-pattern>
							</servlet-mapping>
							
							<servlet-mapping>
								<servlet-name>LoginProxyServlet</servlet-name>
								<url-pattern>/login</url-pattern>
							</servlet-mapping>
							
       	
       	
3���ܽ᣺
		�������ַ�ʽ�ͽ�filter����servlet��ҵ������������ϵ��spring  �����й������Ҳ�����servlet��Ӳ����Ҫ���õĶ������֡�