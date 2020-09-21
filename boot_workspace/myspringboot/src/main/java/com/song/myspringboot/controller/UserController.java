package com.song.myspringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.song.myspringboot.entity.User;
import com.song.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

//	@GetMapping("/delete/{id}")
//	public String deleteUser(@PathVariable("id") long id, Model model) {
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//		userRepository.delete(user);
////		model.addAttribute("users", userRepository.findAll());
//		return "redirect:/index";
//	}
	
	@GetMapping("/delete/{email}")
	public String deleteUser(@PathVariable String email, Model model) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + email));
		userRepository.delete(user);
//		model.addAttribute("users", userRepository.findAll());
		return "redirect:/index";
	}

	

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}
		userRepository.save(user);
//		model.addAttribute("users", userRepository.findAll());
		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String addUserForm(User user) {
		return "add-user";
	}

	@PostMapping("/addUser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		// 입력항목에 에러가 있는지 check
		if (result.hasErrors()) {
			// 에러가 있으면 입력Form 페이지가 다시 요청됨
			return "add-user";
		}
		// 등록
		userRepository.save(user);
//		model.addAttribute("users", userRepository.findAll());
		return "redirect:index";
	}

	@GetMapping("/index")
	public ModelAndView getUsers() {
		List<User> userList = userRepository.findAll();
		return new ModelAndView("index", "users", userList);
	}

	@GetMapping("/leaf")
	public String index(Model model) {
		model.addAttribute("myName", "타임리프");
		return "leaf_first";
	}

	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}

}
