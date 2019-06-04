﻿package controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Member;
import model.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private ArrayList<Member> memberList; // 회원 정보 테이블에 매핑되는 객체
	private Member memberDTO; // 회원 정보 레코드에 매핑되는 객체
	private MemberDAO memberDAO; // 회원 정보 처리를 위해 파일 또는 데이터베이스를 접근하는 객체
	
	public MemberServiceImpl() {
		this(new File("member.txt"));	
		//this() -> 현제 객체의 생성자 호출
	}
	public MemberServiceImpl(File file) {
		memberDAO = new MemberDAO(file);
	}
	
	@Override
	public Member read(Member member) {
		return memberDAO.selectMember(member);
	}

	@Override
	public ArrayList<Member> readList() {
		return memberDAO.selectAll();
	}

	@Override
	public int create(Member member) {
		if(memberDAO.insert(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int update(Member member) {
		if(memberDAO.update(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int delete(Member member) {
		if(memberDAO.delete(member) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public int findByUid(Member member) {
		return memberDAO.searchByID(member);
	}

}
