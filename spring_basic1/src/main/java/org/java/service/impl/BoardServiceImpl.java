package org.java.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.java.service.BoardService;
import org.project.dao.BoardDao;
import org.project.dao.MemberDao;
import org.project.dto.BoardDto;
import org.project.dto.MemberDto;
import org.project.entity.BoardEntity;
import org.project.entity.MemberEntity;



public class BoardServiceImpl implements BoardService{

	@Override
	public int save(BoardDto boardDto) {
		System.out.println("게시판 등록");
		
		MemberDao memberDao=MemberDao.getInstance();
		//멤버아이디 확인
		MemberEntity memberEntity=memberDao.findById(boardDto.getMemberId());
		
		if(memberEntity==null) {
			throw new NullPointerException("조회하신 아이디가 없습니다");
		}
		
		BoardDao boardDao=BoardDao.getInstance();
		
		int rs= boardDao.save(BoardEntity.toInsertBoardEntity(boardDto));
		
	
		return rs;
	}

	@Override
	public List<BoardDto> findAll() {
		System.out.println("게시판 목록전체조회");
		
		BoardDao boardDao=BoardDao.getInstance();
		
		List<BoardEntity> boardEntity=boardDao.findAll();
		
		if(boardEntity==null) {
			throw new IllegalArgumentException("조회할 게시판 데이터가 없습니다!");
			
		}
		
		return boardEntity.stream().map(BoardDto::toSearchDtoBoardDto).collect(Collectors.toList());
	
	}

	@Override
	public BoardDto findById(Long boardId) {
		System.out.println("게시글상세조회(아이디이용)");
		
		BoardDao boardDao=BoardDao.getInstance();
		BoardEntity boardEntity= boardDao.findById(boardId);
		
		if(boardEntity==null) {
			throw new IllegalArgumentException("조회하신 게시글이 없습니다");
		}
		
	
		return BoardDto.toSearchDtoBoardDto(boardEntity);
	}

	@Override
	public int update(BoardDto boardDto) {
		System.out.println("게시판 수정");
		
		
		BoardDao boardDao=BoardDao.getInstance();
		int rs=boardDao.update(BoardEntity.toUpdateBoardEntity(boardDto));
		

		return rs;
	}
	
	

	@Override
	public int delete(Long boardId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	////중요,게시글작성자의 정보를 조회
	@Override
	public MemberDto findByBoardId(Long boardId) {
		 BoardDao boardDao=BoardDao.getInstance();
		 
		 BoardEntity boardEntity=boardDao.findById(boardId);
		 if(boardEntity==null) {
			 throw new NullPointerException();
		 }
		 
		 MemberEntity memberEntity=boardDao.findByBoardId(boardId);
		
		if(memberEntity==null) {
			throw new NullPointerException();
		}
		
		return MemberDto.toSearchMemberDto(memberEntity);
	}

	@Override
	public List<BoardDto> findByMemberIdAndBoardEntity(Long memberId) {
		
		MemberDao memberDao=MemberDao.getInstance();
		
		MemberEntity memberEntity=memberDao.findById(memberId);
		
		if(memberEntity==null) {
			throw new NullPointerException("조회하신 아이디가 없습니다");
		}
		
		
		BoardDao boardDao=BoardDao.getInstance();
		List<BoardEntity> boardEntity=boardDao.findByMemberIdAndBoardEntity(memberId);
		
		
		if(boardEntity.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
	
		return boardEntity.stream().map(BoardDto::toSearchDtoBoardDto).collect(Collectors.toList());
	}


}
