package com.bharatonjava.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.bharatonjava.domain.Department;
import com.bharatonjava.domain.Employee;


public class XmlMarshaller {
	
	private static final String FILE_NAME = "department.xml";
	
	
	
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void saveDepartment() throws IOException {
		FileOutputStream os = null;
		Employee e1 = new Employee("Bharat", 30, 50000);
		Employee e2 = new Employee("Jayant", 22, 40000);
		
		Department d = new Department();
		d.setName("Accounts");
		d.getEmployees().add(e1);
		d.getEmployees().add(e2);
		
		try {
			os = new FileOutputStream(FILE_NAME);
			this.marshaller.marshal(d, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void loadDepartment() throws IOException {
		FileInputStream is = null;
		
		Department d = null;
		try {
			is = new FileInputStream(FILE_NAME);
			d = (Department) this.unmarshaller.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
		
		System.out.println(d);
	}

	public static void main(String[] args) throws IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		XmlMarshaller marsheller = (XmlMarshaller) appContext
				.getBean("marsheller");
		marsheller.saveDepartment();
		
		marsheller.loadDepartment();
		System.out.println("done.");
	}
}