package com.orenda.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orenda.model.UserLogin;


@Repository
public class LoginDaoImpl  implements ILoginDao {
     
	@Autowired
	SessionFactory factory;
	
	public UserLogin fetchEmail(String userEmail) {
		UserLogin userdata =new UserLogin();
		 System.out.println("inside of dao");
		Session session= factory.openSession();
		Query query=session.createQuery("from UserLogin where userEmail=:userEmail");
		List user = query.setParameter("userEmail", userEmail).getResultList();
		System.out.println(user+"   kkkkkkkkk");
		if(user.size()>0) {
			userdata=(UserLogin) user.get(0);
		}
		return userdata;
		
	}

	@Override
	public void saveData(String password) {
		//System.out.println(userEmail);
		
	}


}
