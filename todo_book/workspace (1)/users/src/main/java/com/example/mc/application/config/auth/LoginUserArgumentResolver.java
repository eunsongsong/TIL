package com.example.mc.application.config.auth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.mc.application.config.auth.dto.SessionUser;

@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
    private HttpSession httpSession;

    @Override //controller memthod에 특정 파라미터 지원하는지 판단
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation
                = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass
                = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass;
    }

    @Override  //parameter 에 전달할 객체 생성
    public Object resolveArgument(MethodParameter parameter
                                , ModelAndViewContainer mavContainer
                                , NativeWebRequest webRequest
                                , WebDataBinderFactory binderFactory) throws Exception {
         return httpSession.getAttribute("user");
    }
}
