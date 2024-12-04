package org.project.dto;

import java.time.LocalDateTime;

import org.project.constraint.Role;
import org.project.entity.MemberEntity;



public class MemberDto {

	private Long memberId;
	private String userEmail;
	private String userName;
	private int age;
	private Role role;
	
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(Long memberId, String userEmail, String userName, int age, Role role, LocalDateTime createTime,
			LocalDateTime updateTime) {
		super();
		this.memberId = memberId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.age = age;
		this.role = role;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	
	//회원조회
	public static MemberDto toSearchMemberDto(MemberEntity memberEntity) {
		MemberDto memberDto=new MemberDto();
		
		memberDto.setUserEmail(memberEntity.getUserEmail());
		memberDto.setUserName(memberEntity.getUserName());
		memberDto.setAge(memberEntity.getAge());
		memberDto.setRole(memberEntity.getRole());
		memberDto.setCreateTime(memberEntity.getCreateTime());
		
		
		return memberDto;
	}
	
}
