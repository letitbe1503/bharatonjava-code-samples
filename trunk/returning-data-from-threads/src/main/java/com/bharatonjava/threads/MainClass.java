package com.bharatonjava.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bharatonjava.domain.Employee;

public class MainClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		List<Callable<Employee>> lst = new ArrayList<Callable<Employee>>();
		lst.add(new TaskAsCallable(1001));
		lst.add(new TaskAsCallable(1002));
		lst.add(new TaskAsCallable(1003));
		lst.add(new TaskAsCallable(1004));
		lst.add(new TaskAsCallable(1005));
		
		// returns a list of Futures holding their status and results when all complete
		List<Future<Employee>> results = executorService.invokeAll(lst);
		
		System.out.println(results.size() +" Responses recieved.\n");
		
		for(Future<Employee> result : results)
		{
			System.out.println(result.get().toString());
		}
		

		/* shutdown your thread pool, else your application will keep running */
		executorService.shutdown();
		
	}
}
