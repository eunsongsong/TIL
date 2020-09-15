package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService service;

	public UserController() {
		System.out.println("==> UserController �⺻ ������ ȣ���");
	}

	@RequestMapping("/getUserList.do")
	public String getUsers(Model model) {
		List<UserVO> userList = service.getUserList();
		model.addAttribute("users", userList);
		return "userList";
	}

	@RequestMapping("/getUser.do")
//	public ModelAndView getUser(@RequestParam String userid) {
	public ModelAndView getUser(@RequestParam("userid") String id) {
		UserVO user = service.getUser(id);
		return new ModelAndView("userDetail", "uservo", user);
	}

	@RequestMapping("/insertUserForm.do")
//	public ModelAndView insertUserForm(HttpSession session) {
	public String insertUserForm(HttpSession session) {
		
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");

		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("�뱸");
		cityList.add("����");
		
		//Session�� genderList�� cityList�� ����
		session.setAttribute("gender", genderList);
		session.setAttribute("city", cityList
				);

//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

//		return new ModelAndView("userInsert", "map", map);
		return "userInsert";
	}

	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user) {
		// ��� ��û
		service.insertUser(user);
		
		//��� �Ŀ� �ٷ� ����� ����Ʈ�� ȭ�鿡 ���
		
		
		return "redirect:/getUserList.do";
	}
}
