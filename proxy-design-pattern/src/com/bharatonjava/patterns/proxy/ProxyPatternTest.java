package com.bharatonjava.patterns.proxy;

import java.lang.reflect.Proxy;

public class ProxyPatternTest {

	public static void main(String... args) {

		Employee realObject = new Cleark();

		Employee proxy = (Employee) Proxy.newProxyInstance(realObject.getClass()
				.getClassLoader(), realObject.getClass().getInterfaces(), new EmployeeInvocationHandler(realObject));
		
		String name = proxy.getName();
		System.out.println(name);
	}
}
