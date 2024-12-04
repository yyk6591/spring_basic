package org.java.service.impl;

import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import org.java.service.MemberService;
import org.project.dao.MemberDao;
import org.project.dto.MemberDto;
import org.project.entity.MemberEntity;

import com.mysql.cj.Session;



public class MemberServiceImpl implements MemberService{

	@Override
	public int save(MemberDto memberDto) {
		System.out.println("회원가입");
		
		//userEmail 존재여부 확인
		MemberDao memberDao=MemberDao.getInstance();
		MemberEntity memberEntity= memberDao.findbyUserEmail(memberDto.getUserEmail());
		
		if(memberEntity!=null) {
			throw new IllegalArgumentException("작성하신 이메일이 존재합니다");
		}
		
		//회원가입 실행
		int rs=memberDao.save(MemberEntity.toInsertMemberEntity(memberDto));
		
		if(rs!=1) {
			System.out.println("회원가입실패!");
		}
		
		return rs;
	}

	@Override
	public List<MemberDto> findAll() {
		System.out.println("회원목록조회");
		MemberDao memberDao=MemberDao.getInstance();
		List<MemberEntity> memberEntities=memberDao.findAll();
		
		if(memberEntities.isEmpty()) {
			throw new NullPointerException("조회할 데이터가 없습니다");
		}
	
		return memberEntities.stream().map(MemberDto::toSearchMemberDto).collect(Collectors.toList());
	}

	
	@Override
	public MemberDto findById(Long memberId) {
		System.out.println("회원상세조회");
		
		MemberDao memberDao=MemberDao.getInstance();
		MemberEntity memberEntity = memberDao.findById(memberId);
		
		if(memberEntity==null) {
			throw new IllegalArgumentException("조회하신 아이디를 가진 회원이 없습니다");
		}
	
		return MemberDto.toSearchMemberDto(memberEntity);
	}

	@Override
	public int update(MemberDto memberDto) {
		System.out.println("회원수정");
		
		MemberDao memberDao=MemberDao.getInstance();
		
		 int rs=memberDao.updateSave(MemberEntity.toUpdateMemberEntity(memberDto));
		
	
		return rs;
	}

	@Override
	public int delete(Long memberId) {
		System.out.println("회원삭제");
		
		MemberDao memberDao=MemberDao.getInstance();
		
		
		
		
		return 0;
	}

	@Override
	public MemberDto authLogin(String userEmail, String userName) {
	
		MemberDao memberDao=MemberDao.getInstance();
		MemberEntity memberEntity=memberDao.findbyUserEmail(userEmail);
		
		if(memberEntity==null) {
			throw new IllegalArgumentException("등록 이메일이 있습니다");
		}
		
		MemberEntity memberEntity2=memberDao.findByUserEmailAndUserName(userEmail,userName);
	
		
		
		return MemberDto.toSearchMemberDto(memberEntity2);
	}

}
