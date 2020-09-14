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
		System.out.println("MyServlet Default Constructor ȣ���!!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println(">> MyServlet init() �޼��� ȣ���");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(">> MyServlet doGet() �޼��� ȣ���"); // ���ΰ�ħ �� ������ ȣ���

//		response.getWriter().append("Served ad: ").append(request.getContextPath());

		Date myDate = new Date();

		// MimeType ����, ���� �����Ϳ� ���� �ѱ� ���ڵ�
		response.setContentType("text/html;charset=utf-8");

		// Character(���ڿ�)�� ó���ϴ� Stream ����
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1> ���� ��¥��: " + myDate + "</h1>");
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
		
		// ��û �����Ϳ� ���� �ѱ� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		
		// Form �Է� �����͸� ������ ����
		String userId = request.getParameter("userId");
		String name = request.getParameter("firstName");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr) + 10;
		
		// MimeType ����, "���� ������"�� ���� �ѱ� ���ڵ� - "��û ������"�� ���� ���ڵ��� ���� ����� ��
		response.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>UserID : " + userId + "</h2>");
		out.println("<h2>Name : " + name + "</h2>");
		out.println("<h2>Age : " + age + "</h2>");
		out.close();
		
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet destroy() �޼��� ȣ���"); // servlet �޼��忡 ���� ������ ���� �� ȣ���
	}

}
