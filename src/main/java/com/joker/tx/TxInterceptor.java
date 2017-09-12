package com.joker.tx;

import java.lang.reflect.Method;

import com.joker.connection.TransactionUtil;
import com.joker.tx.entity.Transaction;

public class TxInterceptor extends Interceptor {
	
	public void before(Method method, Object[] args) {
		//1:开启事务
		Transaction tx = method.getAnnotation(Transaction.class);
		if (tx != null) {
			TransactionUtil.startTransaction();
		}
	}

	public void after(Method method, Object[] args,Exception e) {
		Transaction tx = method.getAnnotation(Transaction.class);
		if (tx != null) {
			//事务结束
			try {
				if (e != null) {
					TransactionUtil.roolback();
				} 
			} finally {
				TransactionUtil.commit();
				TransactionUtil.release();
			}
		}
	}


}
