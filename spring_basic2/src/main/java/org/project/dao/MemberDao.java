package org.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.project.connect.DBConnect;
import org.project.constraint.Role;
import org.project.entity.MemberEntity;



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
	
	public List<MemberEntity> findAll(){
		
		
		List<MemberEntity> memberEntities=new ArrayList<MemberEntity>();
		Connection conn=null;
		String query="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			conn=DBConnect.getConnection();
			query="select * from member_tb1";
			pstm=conn.prepareStatement(query);
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntities.add(new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), 
							rs.getString(3), 
							0, null, null, null));////
				}
			}
			
			
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
			pstm.setInt(1, memberId.intValue());
			rs=pstm.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					memberEntity=new MemberEntity(new Long(rs.getInt(1)), rs.getString(2), 
							rs.getString(3), rs.getInt(4), Role.valueOf(rs.getString(5)), 
							rs.getTimestamp(6).toLocalDateTime(), null);
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
