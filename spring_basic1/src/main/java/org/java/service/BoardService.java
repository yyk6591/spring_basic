package org.java.service;

import java.util.List;

import org.project.dto.BoardDto;
import org.project.dto.MemberDto;




public interface BoardService {

	int save(BoardDto boardDto);  //게시글 작성
	List<BoardDto> findAll();   //게시글 조회(목록)
	BoardDto findById(Long boardId);   //게시글조회(상세)
	int update(BoardDto boardDto);   //게시글 수정
	int delete(Long boardId);   //게시글 삭제
	
	//*****inner-join  <- 게시글 작성자의 정보를 조회(username)
	MemberDto findByBoardId(Long boardId);
	
	List<BoardDto> findByMemberIdAndBoardEntity(Long memberId);
	
	
}
