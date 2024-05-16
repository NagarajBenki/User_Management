package com.nagaraj.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagaraj.user.entity.UserAccount;

import jakarta.transaction.Transactional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

	@Modifying
	@Transactional
	@Query("update UserAccount set active_sw = :status where userId =:id")
	public void updateUserAccountStatus(Integer id, String status);
	
}
