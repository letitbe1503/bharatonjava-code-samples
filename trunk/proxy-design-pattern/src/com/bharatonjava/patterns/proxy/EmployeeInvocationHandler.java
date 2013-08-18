package com.bharatonjava.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeInvocationHandler implements InvocationHandler {

	private Object realObject;

	public EmployeeInvocationHandler(Object realObject) {
		this.realObject = realObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		// you have opportunity to do something before invoking the actual method
		
		Object result = null;
		try {
			result = method.invoke(realObject, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// you have opportunity to do something after invoking the actual method
		
		return result;
	}

}
