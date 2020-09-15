package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

//@Controller
// @RestController = @Controller + @ResponseBody
@RestController
public class RESTUserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/users/{userid}")
//	@ResponseBody
	// java object -> json º¯È¯
	public UserVO getUser(@PathVariable String userid) {
		UserVO user = userService.getUser(userid);
		return user;
	}

	@GetMapping("/users")
	public List<UserVO> getUsers() {
		return userService.getUserList();
	}

	@PostMapping("/users")
	// json -> java object
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@PutMapping("/users")
	public Boolean updateUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	@DeleteMapping("/users/{id}")
	public Boolean deleteUser(@PathVariable("id") String userid) {
		if (userid != null) {
			userService.deleteUser(userid);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	@GetMapping("/usersXml")
	public UserVOXML getUsersXml() {
		UserVOXML xml = new UserVOXML();
		xml.setStatus("succeed");
		xml.setUserList(userService.getUserList());
		return xml;
		
	}

}
