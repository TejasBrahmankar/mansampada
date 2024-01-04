package com.tableslearnedmapping.entitymapping.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tableslearnedmapping.entitymapping.entities.Relative;
import com.tableslearnedmapping.entitymapping.entities.User;
import com.tableslearnedmapping.entitymapping.entities.UserInfo;
import com.tableslearnedmapping.entitymapping.repo.Relativerepo;
import com.tableslearnedmapping.entitymapping.repo.UserInforepo;
import com.tableslearnedmapping.entitymapping.repo.Userrepo;
import com.tableslearnedmapping.entitymapping.service.UserService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Userrepo userRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private UserInforepo userinforepo;
	@Autowired
	private Relativerepo relativerepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m,HttpServletRequest request) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}
		String currentUrl = request.getRequestURI();
	    m.addAttribute("justUrl", currentUrl);
	}
	//all userinfo
	@GetMapping("/profile")
	public String profile(Principal p,Model m) {
		// List<UserInfo> allUserInfo = userService.getAllUserInfo();	
		 String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		 UserInfo userinfo = user.getUserInfo();
			m.addAttribute("userinfo", userinfo);
			List<UserInfo> allUserInfo= userinforepo.findAllExceptLoggedInUser(user.getUserId());
	        m.addAttribute("allUserInfo", allUserInfo);
		return "profile";
	}
	
	//view full bidata of others by id
	@GetMapping("/{infoId}/biodata")
	public String viewOtherProfile(@PathVariable("infoId")Integer infoId,Model m,Principal p)
	{
		Optional<UserInfo> userinformation = this.userinforepo.findById(infoId);
		UserInfo userinfo = userinformation.get();
		Set<Relative> relatives=userinfo.getUser().getRelatives();
		m.addAttribute("allrelatives", relatives);
		m.addAttribute("userinfo", userinfo);
		return "show_others_profile";
	}
	
	
	@GetMapping("/add_profile")
	public String add_profile(@ModelAttribute User user,Model m)
	{
		
		 m.addAttribute("userInfo", new UserInfo());
		return "create_profile";
		
		
	}

	@PostMapping("/saveProfile")
	public String save_profile(@ModelAttribute UserInfo userinfo,@RequestParam("pimage")MultipartFile file,Principal p,Model m)
	{
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		
		userService.processUserInfoImage(userinfo,file);
		 userService.saveUserInfo(userinfo, user);
		 m.addAttribute("userinfo", userinfo);
		return "redirect:/user/show_profile";
		 
	}
	@GetMapping("/show_profile")
	public String show_profile(Model m,Principal p)
	{
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		UserInfo userinfo = user.getUserInfo();
		m.addAttribute("userinfo", userinfo);
		return "show_profile";
	}
	
	@GetMapping("/add_relative")
	public String add_relative(Model m)
	{
		m.addAttribute("relative",new Relative());
		return "add_relative";
	}
	
	@PostMapping("/process_relative")
	public String save_relative(@ModelAttribute Relative relative,Principal p,Model m)
	{

		String email = p.getName();
		User user = userRepo.findByEmail(email);	
		 userService.saveRelativeInfo(relative, user);
		 m.addAttribute("relative", relative);
		 return "add_relative";
	}
	
	@GetMapping("/show_relatives")
	public String show_relatives(Principal p,Model m)
	{
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		Set<Relative> relatives = this.relativerepo.findRelativesByUser(user.getUserId());
		System.out.println(relatives);
		m.addAttribute("relatives", relatives);
		return "show_relatives";
	}
	
	//delete relative by id
	@GetMapping("delete/{relativeId}")
	public String deleteRelative(@PathVariable("relativeId")Integer relativeId,Model m,Principal p)
	{
		userService.deleteRelativeById(relativeId);
		
		return "redirect:/user/show_relatives";
	}
	
	//delete userinfo and all relatives
	@GetMapping("/deleteProfileAndRelatives")
	public String deleteProfileAndRelatives(Principal p)
	{
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		UserInfo userinfo = user.getUserInfo();
		Set<Relative> relatives = user.getRelatives();
		userService.deleteAllUserInfoAndRelatives(userinfo, relatives);
		return "redirect:/user/profile";
	}
	
	//update form preview
	@PostMapping("/update/{cid}")
	public String updateForm(@PathVariable("cid")Integer cid, Model m)
	{
		UserInfo userinfo = this.userinforepo.findById(cid).get();
		m.addAttribute("userinfo", userinfo);
		System.out.println(userinfo);
		return "update_profile";
	}
	//save update form
	@PostMapping("/process_updateProfile")
	public String saveUpdateForm(@ModelAttribute UserInfo userinfo,@RequestParam("pimage")MultipartFile file,Principal p,Model m)
	{
		userService.saveUpdateProfile(userinfo, file, p);
		return "redirect:/user/show_profile";
	}
}
