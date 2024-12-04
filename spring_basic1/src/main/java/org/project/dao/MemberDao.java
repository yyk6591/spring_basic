package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.project.constraint.Role;
import org.project.entity.MemberEntity;
import org.web.connect.DBConnect;



public class MemberDao {

	private MemberDao() {
		System.out.println("MemberDao-> 싱글톤 -> 객체한번만 생성");
	}
	
	private static class SingleTonClass{
		private static final MemberDao INSTANCE=new MemberDao();
	}
	
	public static MemberDao getInstance() {
		return SingleTonClass.INSTANCE;
	}
	
	
	//////////////////

	public MemberEntity findbyUserEmail(String userEmail) {
	
		MemberEntity memberEntity=null;
		
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			conn=DBConnect.getConnection();
			query="select * from member_tb1 where user_email=? ";
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userEmail);
			
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntity=new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getInt(4), Role.valueOf(rs.getString(5)), null, null);
				}
			}
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return memberEntity;
	}

	
	
	public int save(MemberEntity memberEntity) {
		
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		int rs=0;
		
		try {
			conn=DBConnect.getConnection();
			query="insert into member_tb1(user_email,user_name,AGE,ROLE,CREATETIME) "
					+" values(?,?,?,?,?) ";
			pstm=conn.prepareStatement(query);
		
			pstm.setString(2, memberEntity.getUserEmail());
			pstm.setString(3, memberEntity.getUserName());
			pstm.setInt(4, memberEntity.getAge());
			pstm.setString(5, memberEntity.getRole().toString());
			pstm.setTimestamp(6, Timestamp.valueOf(memberEntity.getCreateTime()));
			
			rs=pstm.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return rs;
	}


	public List<MemberEntity> findAll() {
		
		List<MemberEntity> memberEntities=new ArrayList<MemberEntity>();
		
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConnect.getConnection();
			query="select * from MEMBER_TB1";
			pstm=conn.prepareStatement(query);
			
			System.out.println(query+" <<query ");
			rs=pstm.executeQuery();

			if(rs!=null) {
				while(rs.next()) {
					memberEntities.add(new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3),
							rs.getInt(4), Role.valueOf(rs.getString(5)), rs.getTimestamp(6).toLocalDateTime(), null));
				}
			}
			
			
			

		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		return memberEntities;
	}


	public MemberEntity findById(Long memberId) {
		
		MemberEntity memberEntity=null;
		
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConnect.getConnection();
			query="select * from member_tb1 where member_id=? ";
			pstm=conn.prepareStatement(query);
			pstm.setLong(1,memberId);
			
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntity=new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getInt(4), Role.valueOf(rs.getString(5)), null, null);
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		return memberEntity;
	}


	public int updateSave(MemberEntity memberEntity) {
	
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		int rs=0;
		
		try {
			conn=DBConnect.getConnection();
			query="update  member_tb1 \" + \" set user_email=?,user_name =?, age=?, role=?, createTime=?, updateTime=?\"\r\n"
					+ "+ \" where member_id=? \";";
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, memberEntity.getUserEmail());
			pstm.setString(2, memberEntity.getUserName());
			pstm.setInt(3, memberEntity.getAge());
			pstm.setString(4, Role.MEMBER.toString());
			pstm.setTimestamp(5, Timestamp.valueOf(memberEntity.getCreateTime()));
			pstm.setTimestamp(6, Timestamp.valueOf(memberEntity.getUpdateTime()));
			pstm.setInt(7, memberEntity.getMemberId().intValue());
			
			
			rs=pstm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return 0;
	}


	public MemberEntity findByUserEmailAndUserName(String userEmail, String userName) {
		
		MemberEntity memberEntity=null;
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBConnect.getConnection();
			query="select * from member_tb1 where user_email=? and user_name;";
			pstm=conn.prepareStatement(query);
			pstm.setString(1, userEmail);
			pstm.setString(2, userName);
			
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntity=new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), rs.getString(3),
							rs.getInt(4), Role.valueOf(rs.getString(5)),
							null, null);
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null)  rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		return memberEntity;
	}
	
	
	
	
	
	
	
}
