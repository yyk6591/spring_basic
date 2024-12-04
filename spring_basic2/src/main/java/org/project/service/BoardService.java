package org.project.service;


import java.util.List;

import org.project.dto.BoardDto;


public interface BoardService {

	
	int save(BoardDto boardDto);
	List<BoardDto> findAll();
	BoardDto findById(Long boardId);
	int update(BoardDto boardDto);
	int delete(Long boardId);
	
	
	
}
