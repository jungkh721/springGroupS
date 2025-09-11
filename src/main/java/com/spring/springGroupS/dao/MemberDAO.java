package com.spring.springGroupS.dao;

import org.apache.ibatis.annotations.Param;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMemberIdCheck(@Param("mid") String mid);

	MemberVO getMemberNickCheck(@Param("nickName") String nickName);

	int setMemberJoin(@Param("vo") MemberVO vo);

	void setLastDateUpdate(@Param("mid") String mid);

	int setMemberPwdChange(@Param("mid")String mid, @Param("pwd")String pwd);


}
