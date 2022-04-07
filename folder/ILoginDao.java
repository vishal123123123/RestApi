package com.orenda.dao;

import com.orenda.model.UserLogin;

public interface ILoginDao {

	UserLogin fetchEmail(String userEmail);

	void saveData(String password);


}
