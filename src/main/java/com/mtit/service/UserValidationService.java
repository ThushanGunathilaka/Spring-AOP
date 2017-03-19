package com.mtit.service;

public interface UserValidationService {
	public boolean validateDepCurrentUser(int userId);
	public boolean validateWithCurrentUser(int userId);
}
