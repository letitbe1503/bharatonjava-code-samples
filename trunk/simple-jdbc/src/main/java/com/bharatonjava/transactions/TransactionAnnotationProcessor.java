package com.bharatonjava.transactions;

import java.lang.reflect.Method;

public class TransactionAnnotationProcessor {

	public static void begin() {
		// find out who invoked your method.
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//		for (StackTraceElement s : ste) {
//			System.out.println("::: " + s);
//		}

		if (ste != null) {
			// last element in the array has the name of the method that invoked
			// your method.
			//System.out.println(ste.length + " --> " + ste[2]);

			StackTraceElement s = ste[3];

			System.out.println(s.getClassName());
			System.out.println(s.getFileName());
			try {
				for (Method method : Class.forName(s.getClassName())
						.getMethods()) {
					if(method.getName().equals(s.getMethodName()))
					{
						System.out.println( method.getName() + " equal............" + method.isAnnotationPresent(DoInTransaction.class));
						if(method.isAnnotationPresent(DoInTransaction.class)){
							System.out.println("TRANSACTION STARTED.");
						}
						
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
