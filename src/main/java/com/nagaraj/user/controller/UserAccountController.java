package com.nagaraj.user.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagaraj.user.entity.UserAccount;
import com.nagaraj.user.service.UserAccountService;


@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user") //save-user is from index.html
	public String handleSubmitButton(@ModelAttribute("user") UserAccount user, Model model) {
		if(user.getUserId()==null) {
			user.setActive_sw("ACT");			
		}
		user.setCreateDate(LocalDate.now());
		user.setUpdateDate(LocalDate.now());
		String msg = userAccountService.saveOrUpdateUserAccount(user);
		model.addAttribute("msg", msg);
		model.addAttribute("user", new UserAccount()); // to clear the form
//		return "redirect:/users";
		return "index";
	}

	@GetMapping("/edit") //edit-user is from index.html
	public String editUserAccount(@RequestParam("id") Integer id, Model model) {
		UserAccount user1 = userAccountService.getUserAccount(id);
		model.addAttribute("user", user1);
		return "index";
	}
	
	@GetMapping("/delete") //edit-user is from index.html
	public String deletUserAccount(@RequestParam("id") Integer id, Model model) {
		boolean status = userAccountService.deleteUserAccount(id);
		model.addAttribute("msg_update", "User Record Deleted");
		return "forward:/users";
	}

	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserAccount> userList = userAccountService.getAllUserAccountList();
		model.addAttribute("users", userList);
		return "view-users";		
	}

	@GetMapping("/update_act")
	public String statusUpdateAct(@RequestParam( value = "id") Integer id,Model model) {
		userAccountService.updateUserAccountStatus(id, "DAC");
		UserAccount user1 = userAccountService.getUserAccount(id);
		model.addAttribute("msg_update",user1.getFullName()+" Deactivated Successfully");
		return "forward:/users";
	}
	
	@GetMapping("/update_dac")
	public String statusUpdateDac(@RequestParam( value = "id") Integer id,Model model) {
		userAccountService.updateUserAccountStatus(id, "ACT");
		UserAccount user1 = userAccountService.getUserAccount(id);
		model.addAttribute("msg_update",user1.getFullName()+" Activated Successfully");
		return "forward:/users";
	}
}
