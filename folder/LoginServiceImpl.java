package com.orenda.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orenda.dao.ILoginDao;
import com.orenda.model.UserLogin;




@Transactional
@Service
public class LoginServiceImpl implements ILoginService{
 
	@Autowired
	ILoginDao dao;
	
	public boolean fetchByEmail(String userEmail) {
		System.out.println("inside of service");
		 UserLogin user=dao.fetchEmail(userEmail);
		 System.out.println(user);
		if (userEmail != null && userEmail.equals(user.getUserEmail())) {
			    System.out.println(userEmail);
			  System.out.println("preparing for message send"); 
			  String to=userEmail;
			  String from="vishalgavale882@gmail.com"; 
             	String message="http://localhost:4344/lms/for?email+"+userEmail+"";
             	String subject="change the password link";
		    
			  this.sendEmail( message, subject, to,from);
			 		return true;
			
		} else {
             return false;
		}
	}

	private void sendEmail(String message, String subject, String to,String from) {
		
		String host="smtp.gmail.com";
		Properties properties=System.getProperties();
		System.out.println("property"+properties);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
        Session session =Session.getInstance(properties,new Authenticator() {
	
        	protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("vishalgavale882@gmail.com","Vishal@143");
			}
			
			
        }
        );
        session.setDebug(true);
        MimeMessage m=new MimeMessage(session);
        try {
		m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			Transport.send(m);
			System.out.println("send sucessfully message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void savePassword(String password) {
		dao.saveData(password);
		
	}
	
	
	 
} 
