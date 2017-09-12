package com.joker.tx;

import java.lang.reflect.Method;

/**
 * 过滤器父类
 * @author joker
 * @author joker
 * {@link https://github.com/Jokerblazes/tx.git}
 */
public abstract class Interceptor {
	
	Interceptor interceptor;

	/**
	 * 前置方法（用户方法调用前执行）
	 * @param method
	 * @param args
	 * @author joker
	 * {@link https://github.com/Jokerblazes/tx.git}
	 */
	public abstract void before(Method method, Object[] args);
	
	/**
	 * 后置方法（用户方法调用后执行）
	 * @param method
	 * @param args
	 * @author joker
	 * {@link https://github.com/Jokerblazes/tx.git}
	 */
	public abstract void after(Method method, Object[] args,Exception e);

	public Interceptor getInterceptor() {
		return interceptor;
	}

	public void setInterceptor(Interceptor interceptor) {
		if (this.interceptor == null)
			this.interceptor = interceptor;
		else 
			this.interceptor.setInterceptor(interceptor);
	}
	
	public void doBefore(Method method, Object[] args) {
		before(method,args);
		if (interceptor != null)
			interceptor.before(method,args);
	}
	
	public void doAfter(Method method, Object[] args,Exception e) {
		after(method,args,e);
		if (interceptor != null)
			interceptor.after(method,args,e);
	}
	
	
}
