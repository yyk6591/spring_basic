package org.project.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dto.BoardDto;
import org.project.service.BoardService;
import org.project.service.impl.BoardServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet{

	@Override  //@RestController @DELETE
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
		String basicURL=uri.substring(path.length());  //->join.board
		
		String returnURL="";
		
		BoardService service=new BoardServiceImpl();
		
		if(basicURL.equals("/writeView.board")) {
			System.out.println("게시글 작성");
			
		
			returnURL="/write.jsp";
			
		}else if(basicURL.equals("/writeOk.board")) {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Long memberId=Long.valueOf(request.getParameter("memberId"));
			
			int rs=service.save(new BoardDto(null, title, content,
					memberId, null, null));
			
			if(rs==1) {
				returnURL="/boardList.jsp";
			}else {
				returnURL="/";
			}
			response.sendRedirect(request.getContextPath()+"/boardList.board");
			return;
			
		}else if(basicURL.equals("/boardList.board")) {
			
			System.out.println("게시글목록페이지");
			
			List<BoardDto> boardDtos=service.findAll();
			request.setAttribute("boardDtos", boardDtos);
		
			returnURL="/boardList.jsp";
			
		}else if(basicURL.equals("/detail.board")) {
			Long boardId=Long.valueOf(request.getParameter("boardId"));
			
			BoardDto boardDto=service.findById(boardId);
			request.setAttribute("boardDto", boardDto);
			
		}else if(basicURL.equals("delete.board")) {
			Long boardId=Long.valueOf(request.getParameter("boardId"));
			
			int rs=service.delete(boardId);
			
			if(rs==1){
				System.out.println("게시글 삭제 성공!");
				response.sendRedirect(request.getContextPath()+"/boardList.board");
				return;
			}
			
		}else if(basicURL.equals("/updateView.board")) {
			Long boardId=Long.valueOf(request.getParameter("boardId"));
			
			BoardDto boardDto=service.findById(boardId);
			request.setAttribute("boardDto", boardDto);
			
			returnURL="/updateBoard.jsp";
		}else if(basicURL.equals("/updateOk.board")) {
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
		
			
			//String  -> localdatetime 으로 변환
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			LocalDateTime updateTime=LocalDateTime.parse(request.getParameter("updateTime"),formatter);
			
			
			int rs=service.update(new BoardDto(null, title, content, null, null, updateTime));
			
			response.sendRedirect(request.getContextPath()+"/updateView.board?boardId=");
			return;
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
		
		
	}

	
	
}
