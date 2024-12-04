package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.project.connect.DBConnect;
import org.project.constraint.Role;
import org.project.entity.BoardEntity;
import org.project.entity.MemberEntity;


public class BoardDao {

	private BoardDao() {
		System.out.println("MemberDao-> 싱글톤 -> 객체한번만 생성");
	}
	
	private static class SingleTonClass{
		private static final BoardDao INSTANCE=new BoardDao();
	}
	
	public static BoardDao getInstance() {
		return SingleTonClass.INSTANCE;
	}
	
	
public int save(BoardEntity boardEntity) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		int rs = 0;
		
		try {
			conn = DBConnect.getConnection();
			query = "insert into board_tb1(title,content,member_id, createTime )  "
										+ "  values(?,?,?,?)";
			// query실행
			pstm = conn.prepareStatement(query);		
			
			pstm.setString(1, boardEntity.getTitle());
			pstm.setString(2, boardEntity.getContent());
			pstm.setInt(3, boardEntity.getMemberId().intValue());
			pstm.setTimestamp(4, Timestamp.valueOf(boardEntity.getCreateTime()));

			rs = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		
		return rs;
	}


	public List<BoardEntity> findAll() {
		
		List<BoardEntity> boardEntity =new ArrayList<BoardEntity>();
		
		Connection conn = null;
		String query = "";
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		try {
			conn=DBConnect.getConnection();
			query="select * from board_tb1";
			pstm=conn.prepareStatement(query);
			
			rs=pstm.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					boardEntity.add(new BoardEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3), new Long(rs.getInt(4)), null, null));
				}
			}
			

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
		return boardEntity;
	}

	///외래키사용
	public MemberEntity findByBoardId(Long boardId) {
		
		MemberEntity memberEntity=null;
		
		Connection conn = null;
		String query = "";
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConnect.getConnection();
			query="SELECT m.member_id, m.name, m.email, m.age, m.role, m.created_at " +
	                "FROM member m " +
	                "JOIN board b ON m.member_id = b.member_id " +
	                "WHERE b.board_id = ?";
			pstm=conn.prepareStatement(query);
			pstm.setInt(1, boardId.intValue());
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntity= new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3),
							rs.getInt(4),Role.valueOf(rs.getString(5)),
							rs.getTimestamp(6).toLocalDateTime(), null);
				}
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
		return memberEntity;
	}


	public BoardEntity findById(Long boardId) {
		
		BoardEntity boardEntity=null;
		
		Connection conn = null;
		String query = "";
		PreparedStatement pstm = null;
		ResultSet rs=null;
		
		try {
			conn=DBConnect.getConnection();
			query="select * from board_tb1 where board_id=? ";
			pstm=conn.prepareStatement(query);
			pstm.setInt(1, boardId.intValue());
			
			rs=pstm.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					boardEntity=new BoardEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3), new Long(rs.getInt(4)), null, null);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return boardEntity;
	}



	public int update(BoardEntity boardEntity) {
		
		Connection conn = null;
		String query = "";
		PreparedStatement pstm = null;
		int rs=0;
		
		try {
			conn=DBConnect.getConnection();
			query="UPDATE board_tb1 SET title = ?, content = ?, member_id = ? WHERE board_id = ?";
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, boardEntity.getTitle());
			pstm.setString(2, boardEntity.getContent());
			pstm.setInt(3, boardEntity.getMemberId().intValue());
			pstm.setInt(4, boardEntity.getBoardId().intValue());
			
			
			rs=pstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}





	public List<BoardEntity> findByMemberIdAndBoardEntity(Long memberId) {
	
		List<BoardEntity> boardEntity =new ArrayList<BoardEntity>();
		
		Connection conn = null;
		String query = "select b.*\r\n"
				+ "from member_tb1 m inner join board_tb1 b\r\n"
				+ "on m.member_id=b.member_id\r\n"
				+ "where b.member_id=?;";
		PreparedStatement pstm = null;
		ResultSet rs=null;  
		
		try {
			conn=DBConnect.getConnection();
			query="";
			pstm=conn.prepareStatement(query);
					rs=pstm.executeQuery();
							
			if(rs!=null) {
				while(rs.next()) {
					
					//@빌더패턴   제목이랑 내용만 가져올때
//					BoardEntity board= new BoardEntity();
//					board.setTitle(rs.getString(1));
//					board.setContent(rs.getString(2));
//					
//					boardEntity.add(board);
					boardEntity.add(new BoardEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3), new Long(rs.getInt(4)), null, null));
					
		
				}
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return boardEntity;
	}


	public int delete(Long boardId) {
		
		Connection conn = null;
		String query = "";
		PreparedStatement pstm = null;
		int rs=0;
		
		try {
			conn=DBConnect.getConnection();
			query="delete from board_tb1 where board_id=?";
			pstm=conn.prepareStatement(query);
			pstm.setInt(1, boardId.intValue());
			
			rs=pstm.executeUpdate();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return rs;
		
	
	}
	
}
