package com.shalini.rough;

import com.shalini.utilities.MonitoringMail;
import com.shalini.utilities.TestConfig;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class mail {

    public static void main(String[] args) throws UnknownHostException, MessagingException {
        String ip = "http//:"+InetAddress.getLocalHost().getHostAddress()+":8080/job/Selenium_Maven/Extent_20Report/";
        MonitoringMail mail = new MonitoringMail();
        mail.sendMail(TestConfig.server,TestConfig.from,TestConfig.to,TestConfig.subject,ip);
    }
}
