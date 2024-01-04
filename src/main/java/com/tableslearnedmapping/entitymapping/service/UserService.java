package com.tableslearnedmapping.entitymapping.service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.tableslearnedmapping.entitymapping.entities.Relative;
import com.tableslearnedmapping.entitymapping.entities.User;
import com.tableslearnedmapping.entitymapping.entities.UserInfo;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();
	
	public UserInfo saveUserInfo(UserInfo userInfo, User user);
    
	public User saveRelativeInfo(Relative relative, User user);
	
	public List<UserInfo> getAllUserInfo();

	public void processUserInfoImage(UserInfo userInfo, MultipartFile file);
	
	public void deleteRelativeById(Integer relativeId);
	
	public void deleteAllUserInfoAndRelatives(UserInfo userinfo,Set<Relative> relatives);
	
	public void saveUpdateProfile(UserInfo userinfo, MultipartFile file,Principal p);
	
	public List<UserInfo> searchByCriteria(String gotra, String year, String occupation);
	
}
