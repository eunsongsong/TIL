package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/hello")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		System.out.println("MyServlet Default Constructor 호출됨!!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println(">> MyServlet init() 메서드 호출됨");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(">> MyServlet doGet() 메서드 호출됨"); // 새로고침 할 때마다 호출됨

//		response.getWriter().append("Served ad: ").append(request.getContextPath());

		Date myDate = new Date();

		// MimeType 설정, 응답 데이터에 대한 한글 인코딩
		response.setContentType("text/html;charset=utf-8");

		// Character(문자열)를 처리하는 Stream 생성
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1> 현재 날짜는: " + myDate + "</h1>");
		out.println("<h2>" + request.getMethod() + "</h2>");
		out.println("</body></html>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Http Method : " + request.getMethod());
		
		// 요청 데이터에 대한 한글 인코딩
		request.setCharacterEncoding("EUC-KR");
		
		// Form 입력 데이터를 추출해 보기
		String userId = request.getParameter("userId");
		String name = request.getParameter("firstName");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr) + 10;
		
		// MimeType 설정, "응답 데이터"에 대한 한글 인코딩 - "요청 데이터"에 대한 인코딩을 따로 해줘야 함
		response.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>UserID : " + userId + "</h2>");
		out.println("<h2>Name : " + name + "</h2>");
		out.println("<h2>Age : " + age + "</h2>");
		out.close();
		
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet destroy() 메서드 호출됨"); // servlet 메서드에 수정 사항이 있을 때 호출됨
	}

}
