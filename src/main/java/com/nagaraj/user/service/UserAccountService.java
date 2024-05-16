package com.nagaraj.user.service;

import java.util.List;

import com.nagaraj.user.entity.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAccount(UserAccount user);
	
	public List<UserAccount> getAllUserAccountList();
	
	public UserAccount getUserAccount(Integer userId);
	
	public boolean deleteUserAccount(Integer userId);

	public boolean updateUserAccountStatus(Integer id, String status);
	
	
	
}
