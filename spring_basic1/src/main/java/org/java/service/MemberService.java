package org.java.service;

import java.util.List;

import org.project.dto.MemberDto;


public interface MemberService {

	int save(MemberDto memberDto);
	List<MemberDto> findAll();
	MemberDto findById(Long memberId);
	int update(MemberDto memberDto);
	int delete(Long memberId);
	MemberDto authLogin(String userEmail,String userName);
	
}
