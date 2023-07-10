package com.eInvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@SpringBootApplication
public class EInvoicingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EInvoicingApplication.class, args);
	}
//	
//	static {
//		String logPath = "";
//		if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
//			logPath = "/tmp/eInvoicing_logs/";
//		} else {
//			logPath = "D:\\\\eInvoicing_logs\\\\";
//		}
//		System.setProperty("logPath", logPath);
//	}

	
	@Bean(name = "sessionRegistry")
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}
}
