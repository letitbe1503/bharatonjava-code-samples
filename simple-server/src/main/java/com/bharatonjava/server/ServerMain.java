package com.bharatonjava.server;

public class ServerMain {

	public static void main(String[] args) {
		
		Server server = new Server(8080);
		new Thread(server).start();

		try {
		    Thread.sleep(200 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Stopping Server");
		server.stop();
	}
}
