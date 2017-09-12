package com.joker.tx;

import java.lang.reflect.Method;

public abstract class Interceptor {
	
	Interceptor interceptor;
	
	public abstract void before(Method method, Object[] args);
	
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
