package com.tableslearnedmapping.entitymapping.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.tableslearnedmapping.entitymapping.entities.Relative;
import com.tableslearnedmapping.entitymapping.entities.User;
import com.tableslearnedmapping.entitymapping.entities.UserInfo;
import com.tableslearnedmapping.entitymapping.repo.Relativerepo;
import com.tableslearnedmapping.entitymapping.repo.UserInforepo;
import com.tableslearnedmapping.entitymapping.repo.Userrepo;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private Userrepo userRepo;
	@Autowired
	private UserInforepo userinforepo;

	@Autowired
	private Relativerepo relativerepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {

		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		User newuser = userRepo.save(user);

		return newuser;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

	@Override
	public UserInfo saveUserInfo(UserInfo userInfo, User user) {
		
        userInfo.setUser(user); // Set the user for the user info
        
			return userinforepo.save(userInfo);
		
    }

	@Override
	public User saveRelativeInfo(Relative relative, User user) {
		// TODO Auto-generated method stub
		relative.setUser(user);
		user.getRelatives().add(relative);
		
		return this.userRepo.save(user);
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		// TODO Auto-generated method stub
		return userinforepo.findAll();
	}

	 @Override
	    public void processUserInfoImage(UserInfo userInfo, @RequestParam("pimage")MultipartFile file) {
	        try {
	            if (file.isEmpty()) {
	                System.out.println("File is empty");
	                userInfo.setImage("/img/mar2.jpeg");
	            } else {
	                userInfo.setImage(file.getOriginalFilename());
	                File saveFile = new ClassPathResource("static/img").getFile();
	                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
	                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	                System.out.println("Uploaded");
	            }

	          //  userinforepo.save(userInfo);
	            System.out.println("User Info Image Processed");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            // Handle exceptions or logging here
	        }
	    }

	@Override
	@Transactional
	public void deleteRelativeById(Integer relativeId) {
		relativerepo.deleteByRelativeId(relativeId);		
	}

	@Override
	@Transactional
	public void deleteAllUserInfoAndRelatives(UserInfo userinfo, Set<Relative> relatives) {
		// TODO Auto-generated method stub

		if (userinfo != null) {
	        User user = userinfo.getUser();

	        if (relatives != null && !relatives.isEmpty()) {
	            for (Relative relative : relatives)
	            {
	                if (relative.getUser().equals(user))
	                {
	                    relativerepo.delete(relative);
	                }
	            }
	            user.getRelatives().removeAll(relatives); 
	            userRepo.save(user); 
	        }

	        // Delete the userinfo
	        user.setUserInfo(null);
	        userRepo.save(user); 
	        userinforepo.delete(userinfo); 
	    }
	}

	@Override
	public void saveUpdateProfile(UserInfo userinfo, MultipartFile file,Principal p) {
		// TODO Auto-generated method stub
		UserInfo oldinfo = this.userinforepo.findById(userinfo.getInfoId()).get();
		try
		{
			if(!file.isEmpty())
			{
				//delete image
				File deleteFile = new ClassPathResource("static/img").getFile();
				File file1 = new File(deleteFile,oldinfo.getImage());
				file1.delete();
				//update new image
				File saveFile = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				userinfo.setImage(file.getOriginalFilename());
			}
			else
			{
				userinfo.setImage(oldinfo.getImage());
			}
			User user = this.userRepo.findByEmail(p.getName());
			userinfo.setUser(user);
			this.userinforepo.save(userinfo);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
    
	@Override
	 public List<UserInfo> searchByCriteria(String gotra, String year, String occupation) {
	        return userinforepo.findAll(
	                Specification.where(UserInfoSpecifications.hasGotra(gotra))
	                        .and(UserInfoSpecifications.hasYear(year))
	                        .and(UserInfoSpecifications.hasOccupation(occupation))
	                // Add more specifications as needed using 'and' or 'or'
	        );
	    }

}