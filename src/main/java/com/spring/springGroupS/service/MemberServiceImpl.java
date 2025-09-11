package com.spring.springGroupS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springGroupS.dao.MemberDAO;
import com.spring.springGroupS.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public MemberVO getMemberIdCheck(String mid) {
//		MemberVO vo = memberDAO.getMemberIdCheck(mid);
//		System.out.println("vo : " + vo);
//		return vo;
		return memberDAO.getMemberIdCheck(mid);
	}

	@Override
	public MemberVO getMemberNickCheck(String nickName) {
		return memberDAO.getMemberNickCheck(nickName);
	}

	@Override
	public int setMemberJoin(MemberVO vo) {
		return memberDAO.setMemberJoin(vo);
	}

	@Override
	public void setLastDateUpdate(String mid) {
		memberDAO.setLastDateUpdate(mid);
	}

	@Override
	public int setMemberPwdChange(String mid, String pwd) {
		return memberDAO.setMemberPwdChange(mid, pwd);
	}

	
}
