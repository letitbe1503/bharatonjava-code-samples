package com.bharatonjava.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WorkerRunnable implements Runnable {

	protected Socket clientSocket;
	private String HTTP_HEADER = "HTTP/1.1";
	private String HTTP_OK = "200";
	private String HTTP_XML_RESPONSE = "text/xml";
	protected String text = "<?xml version=\"1.0\"?><emp><id>10</id></emp>";

	public WorkerRunnable(Socket clientSocket, String text) {
		this.clientSocket = clientSocket;
		//this.text = text;
	}

	public void run() {
		try {
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();

			long startTime = System.currentTimeMillis();
			
			outputStream.write((HTTP_HEADER+" "+ HTTP_OK + " OK\n"+ HTTP_XML_RESPONSE +"\n"
					+ this.text ).getBytes());
			outputStream.close();
			inputStream.close();
			System.out.println("Request completed in "
					+ (startTime - System.currentTimeMillis()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}
}
