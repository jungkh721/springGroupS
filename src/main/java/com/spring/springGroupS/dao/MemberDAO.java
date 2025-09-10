package com.spring.springGroupS.dao;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMemberIdCheck(String mid);

	MemberVO getMemberNickCheck(String nickName);

}
