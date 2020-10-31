package com.example.mc.application.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mc.application.config.auth.LoginUser;
import com.example.mc.application.config.auth.dto.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController{
	
  private final HttpSession httpSession;
   
//  @GetMapping("/api/users/google")
//  public void login(@PathVariable String target, HttpServletResponse response) throws IOException{
//	   System.out.println("========= login?"+target);
//     response.sendRedirect("/oauth2/authorization/"+target);
//  }
  
  @GetMapping("/") 
  public void oauth(@LoginUser SessionUser user,HttpServletResponse response) throws IOException {
	  //CustomOAuth2UserService 에서 로그인 성공 시 SessionUser 저장
      user = (SessionUser) httpSession.getAttribute("user");
      response.sendRedirect("http://localhost:3000/login/"+user.getEmail());
	//  return user;
  }
  
  @GetMapping("/users/logout")
  public void logout(){
	  if(httpSession != null && httpSession.getAttribute("user") != null ) httpSession.invalidate();
  }
 }
//@Controller
//public class UserController {
//
//    private final HttpSession httpSession;
//
//    @GetMapping("/")
//    public void login(Model model, @LoginUser SessionUser user, HttpServletResponse response) throws IOException{
//        //CustomOAuth2UserService 에서 로그인 성공 시 SessionUser 저장
//         user = (SessionUser) httpSession.getAttribute("user");
//         model.addAttribute("user",user);
//        //annotation @LoginUser 로 변경
//        response.sendRedirect("http://localhost:3000/"); 
//    }
//}  
    
