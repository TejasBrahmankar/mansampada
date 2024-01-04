package com.tableslearnedmapping.entitymapping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.tableslearnedmapping.entitymapping.entities.UserInfo;

public interface UserInforepo extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {
	public List<UserInfo> findAll();
	
	@Query("from UserInfo as c where c.user.userId!=:userId")
	public List<UserInfo> findAllExceptLoggedInUser(@RequestParam("userId")int userId);
}
