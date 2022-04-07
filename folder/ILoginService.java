package com.orenda.service;

public interface ILoginService {

	boolean fetchByEmail(String userEmail);

	void savePassword(String password);

}