package org.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dto.MemberDto;
import org.project.service.MemberService;
import org.project.service.impl.MemberServiceImpl;



@WebServlet("*.member")
public class MemberController extends HttpServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DELETE");
		doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");
		doPost(req, resp);
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PUT");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		
		request.setCharacterEncoding("UTF-8");
		
		String path=request.getContextPath();
		String uri=request.getRequestURI();
		String basicURL=uri.substring(path.length());
		
		MemberService service=new  MemberServiceImpl() {
			
			@Override
			public MemberDto authLogin(String userEmail, String userName) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
		
		String returnURL="";
		if(basicURL.equals("/join.member")) {
			returnURL="/join.jsp";
			
		}else if(basicURL.equals("joinOK.member")) {
			
			//클라이언트 요청 데이터 읽기(가져오기)
			String userEmail=request.getParameter("userEmail");
			String userName=request.getParameter("userName");
			int age=Integer.parseInt(request.getParameter("age"));
			
			int rs=service.save(new MemberDto(null, userEmail, userName, age, null, null, null));
			
			if(rs==1) {
				returnURL="/login.jsp";
			}else {
				returnURL="/";
			}
			
		}else if(basicURL.equals("/memberList.member")) {
//			List<MemberDto> memberDtos=service  .findAll();
			
			//setAttribute 사용
		}else if(basicURL.equals("/detail.member")) {
			Long memberId=Long.valueOf(request.getParameter("memberId"));
			
//			MemberDto memberDto=service.findbyId(memberId);
//			request.setAttribute("memberDto", memberDto);
			
			
		}else if(basicURL.equals("/delete.member")){
			Long memberId=Long.valueOf(request.getParameter("memberId"));
			
			int rs=service.deleteId(memberId);
			
//			PrintWriter out=response.getWriter();
//			response.setContentType("text/html;charset=utf-8");
			
			if(rs==1) {
				System.out.println("회원 탈퇴성공!");
//				out.print("<script>");
//				out.print("alert('회원탈퇴성공!')");
//				out.print("</script>");
//				returnURL="/memberList.jsp";
				
				
				//Controller -> Mapping 경로로 바로 이동 : sendRedirect
				response.sendRedirect(request.getContextPath()+"/memberList.member");
				return;    //페이지이동 없이 값만 리턴함
				
			
				//spring boot 에서는 이렇게 씀 -> @Controller -> /board/boardList
				//return "redirect:/board/boardList";
				
				
				
				
			}else if(basicURL.equals("/updateView.member")) {
				
//				Long memberId=Long.valueOf(request.getParameter("memberId"));
//				
//				MemberDto memberDto=service.findbyId(memberId);
//				request.setAttribute("memberDto", memberDto);
				
				
				returnURL="/update.jsp";
			}else if(basicURL.equals("/updateOk.member")) {
				
				String userName=request.getParameter("userName");
				int age=Integer.parseInt(request.getParameter("age"));
				
				
				//String  -> localdatetime 으로 변환
				DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
				LocalDateTime updateTime=LocalDateTime.parse(request.getParameter("updateTime"),formatter);
				
				int rss= service.update(new MemberDto(null, null, userName,
						age, null, null, null));
				

				//회원수정시 -> 수정 이후에 같은페이지로 이동
				response.sendRedirect(request.getContextPath()+"/updateView.member?memberId="+memberId);
				return;
				
			}else if(basicURL.equals("/loginOk.member")) {
				String userEmail=request.getParameter("userEmail");
				String userName=request.getParameter("userName");
				
				MemberDto loginUser=service.authLogin(userEmail, userName);
				
				//세선 객체 생성
				HttpSession session=request.getSession();
				
				if(loginUser!=null) {
					session.setAttribute("userEmail", loginUser.getUserEmail());
					session.setAttribute("Role", loginUser.getRole().toString());
					session.setAttribute("memberId", loginUser.getMemberId());
					session.setMaxInactiveInterval(60*30);
				}
				
				
			}else if(basicURL.equals("/logout.member")) {
				
				//세선 객체 생성
				HttpSession session=request.getSession();
				
				if(session!=null) {
					session.invalidate();
				}
				returnURL="/";
			}else if(basicURL.equals("/loginView.member")) {
				
				
				returnURL="/login.jsp";
			}
			
			
		}
		
		//@Controller
		//페이지 이동 + 데이터 (뷰역할)
		RequestDispatcher dispatcher
		=request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
