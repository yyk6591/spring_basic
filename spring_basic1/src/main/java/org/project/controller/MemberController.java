package org.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.service.MemberService;
import org.java.service.impl.MemberServiceImpl;
import org.project.dto.MemberDto;

//member -> 

// Controller -> 역할
@WebServlet("*.member")   // join.member,  login.member,,,, ~끝자리가 member 면 얘가 다 받는다
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		doPost(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE");
		doPost(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PUT");
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//요청정보를 받고
//		String remote=request.getRemoteAddr();
//		String serverName= request.getServerName();
//		String protocol=request.getProtocol();
//		
//		System.out.println("remote-> "+remote);
//		System.out.println("serverName-> "+serverName);
//		System.out.println("protocol -> "+protocol);
		
		
		//.member -> .member를 제외한 값을 콘솔에출력 subString
		// /localhost:8085/spring_basic1/join.member-> join.member
		// /localhost:8085/spring_basic1/update.member -> update.member
		// /localhost:8085/spring_basic1/select.member -> select.member
		// /localhost:8085/spring_basic1/delete.member -> delete.member
		
		//localhost:8085/spring_basic1/~.member
		StringBuffer url=request.getRequestURL();//서버의 기본경로 /localhost:8085/spring_basic1
		String path=request.getContextPath();//서버의 기본경로 /localhost:8085/spring_basic1
		String uri=request.getRequestURI(); //요청 URI /localhost:8085/spring_basic1/join.member
		String basicURL=uri.substring(path.length()); //join.member
		
		System.out.println("url -> "+url.toString());
		System.out.println("path -> "+path);
		System.out.println("uri -> "+uri);
		System.out.println(basicURL);
		
		//join.member -> post
		//select.member -> get
		//update.member -> put
		//delete.member -> delete
		
		MemberService service=new MemberServiceImpl();
		MemberDto memberDto=null;
		
		if(basicURL.equals("/join.member")) {
			System.out.println("회원가입");
		}else if(basicURL.equals("/select.member")) {
			System.out.println("회원조회");
			List<MemberDto> memberDtos=service.findAll();
			Map<String, List<MemberDto>> map =new HashMap<String,  List<MemberDto>>();
			map.put("memberList", memberDtos);
			System.out.println(map.get("memberList"));
			
			PrintWriter out=response.getWriter();
			out.println("<!doctype html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>서블릿</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>회원목록</h1>");
		
			
			
			
			out.println("</body>");
			out.println("</!html>");
			
		}else if(basicURL.equals("/detail.member")) {
			System.out.println("회원상세조회");
		}else if(basicURL.equals("/update.member")) {
			System.out.println("회원수정");
		}else if(basicURL.equals("/delete.member")){
			System.out.println("회원삭제");
		}else {
			System.out.println("요청 URL -> 실패!!!");
		}
		
		
		
		
		
		
		
//		System.out.println();
//		Enumeration<String> headerName=request.getHeaderNames();
//		System.out.println("headerName -> "+headerName);
//		while(headerName.hasMoreElements()) {
//			String elName=headerName.nextElement();
//			String header=request.getHeader(elName);
//			System.out.println(elName+ "-> "+header);
//					
//		}
//		
//		
//		String userEmail=request.getParameter("userEmail");
//		String userName=request.getParameter("userName");
//		
//		System.out.println(userEmail);
//		System.out.println(userName);
//		
//		System.out.println("===================");
//		
//		//요청정보에 대한 응답
//		response.setContentType("text/html;charset=utf-8");
		//브라우저에 데이터+자바서블릿 -> 컴파일 -> HTML변환 -> 클라이언트
	
		
		
//		String viewURL="/joinOk.jsp";
//		request.setAttribute("userEmail", userEmail);
//		request.setAttribute("userName", userName);
//		
//		//view -> JSP
//		RequestDispatcher dispatcher= request.getRequestDispatcher(viewURL);
//		
//		dispatcher.forward(request, response);
		
		
	}

	
	
	
	
	
	
	
}
