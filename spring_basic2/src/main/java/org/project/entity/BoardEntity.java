package org.project.entity;

import java.time.LocalDateTime;



import org.project.dto.BoardDto;

public class BoardEntity {

	private Long boardId;
	private String title;
	private String content;
	private Long memberId;   //외래키
	
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	
	public BoardEntity() {
		// TODO Auto-generated constructor stub
	}

	public BoardEntity(Long boardId, String title, String content, Long memberId, LocalDateTime createTime,
			LocalDateTime updateTime) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.memberId = memberId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	//게시판 등록
		public static BoardEntity toInsertBoardEntity (BoardDto boardDto) {
			BoardEntity boardEntity= new BoardEntity();
			
//			boardEntity.setBoardId(boardDto.getBoardId());
			boardEntity.setTitle(boardDto.getTitle());
			boardEntity.setContent(boardDto.getContent());
			boardEntity.setMemberId(boardDto.getMemberId());
			boardEntity.setCreateTime(LocalDateTime.now());
			
			
			
			return boardEntity;
		}
		
		
		//게시판 수정
		public static BoardEntity toUpdateBoardEntity (BoardDto boardDto) {
			BoardEntity boardEntity= new BoardEntity();
			
			boardEntity.setBoardId(boardDto.getBoardId());
			boardEntity.setTitle(boardDto.getTitle());
			boardEntity.setContent(boardDto.getContent());
			boardEntity.setCreateTime(boardDto.getCreateTime());
			boardEntity.setUpdateTime(LocalDateTime.now());
			
			
			return boardEntity;
		}
}
