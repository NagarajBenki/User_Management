package com.nagaraj.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaraj.user.entity.UserAccount;
import com.nagaraj.user.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpls implements UserAccountService{

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public String saveOrUpdateUserAccount(UserAccount user) {
		Integer id = user.getUserId();
		userAccountRepository.save(user);
		if(id == null) {
			return "User Record Saved";
		}else {
			return "User Record Updated";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccountList() {
		return userAccountRepository.findAll();
	}

	@Override
	public UserAccount getUserAccount(Integer userId) {
		Optional<UserAccount> optUserAccount =  userAccountRepository.findById(userId);
		if(optUserAccount.isPresent())
			return optUserAccount.get();
		else
			return null;
	}

	@Override
	public boolean deleteUserAccount(Integer userId) {
		try {
			userAccountRepository.deleteById(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserAccountStatus(Integer id, String status) {
		try {
		userAccountRepository.updateUserAccountStatus(id, status);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}

	
	
}
