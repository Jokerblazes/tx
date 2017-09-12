package com.joker.tx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joker.tx.Interceptor;

public class ServiceInvocationHandler<V> implements InvocationHandler {
	private V service;
	private Interceptor interceptor;
	private static final Logger logger = LoggerFactory.getLogger(ServiceInvocationHandler.class); 
	
	public ServiceInvocationHandler(V service,Interceptor interceptor) {
		this.service = service;
		this.interceptor = interceptor;
		logger.info("初始化！");
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Exception exception = null;
		logger.info("开始执行前置过滤器！");
		interceptor.doBefore(method,args);
		try {
			return method.invoke(service, args);
		} catch (Exception e) {
			e.printStackTrace();
			exception = e;
		}finally {
			logger.info("开始执行后置过滤器！");
			interceptor.doAfter(method,args,exception);
		}
		return null;
	}

}
