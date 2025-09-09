package com.spring.springGroupS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

	@RequestMapping(value = "/message/{msgFlag}", method = RequestMethod.GET)
	public String getMessage(Model model,
			@PathVariable String msgFlag,
			@RequestParam(name="mid", defaultValue = "", required = false) String mid,
			@RequestParam(name="idx", defaultValue = "", required = false) String idx
		) {
		
		if(msgFlag.equals("hoewonInputOk")) {
			model.addAttribute("message", mid + "님 회원에 정상적으로 가입되었습니다.");
			model.addAttribute("url", "/study1/mapping/test35?mid="+mid);
		}
		else if(msgFlag.equals("hoewonInputNo")) {
			model.addAttribute("message", "회원 가입 실패");
			model.addAttribute("url", "/study1/mapping/menu");
		}
		else if(msgFlag.equals("userInputOk")) {
			model.addAttribute("message", "회원 가입 성공");
			model.addAttribute("url", "/user2/userList");
		}
		else if(msgFlag.equals("userInputNo")) {
			model.addAttribute("message", "회원 가입 실패~~");
			model.addAttribute("url", "/user2/userInput");
		}
		else if(msgFlag.equals("userDeleteOk")) {
			model.addAttribute("message", "회원 삭제 성공");
			model.addAttribute("url", "/user2/userList");
		}
		else if(msgFlag.equals("userDeleteNo")) {
			model.addAttribute("message", "회원 삭제 실패~~");
			model.addAttribute("url", "/user2/userList");
		}
		else if(msgFlag.equals("userUpdateOk")) {
			model.addAttribute("message", "회원 정보를 수정하였습니다.");
			model.addAttribute("url", "/user2/userUpdate?idx="+idx);
		}
		else if(msgFlag.equals("userUpdateOk")) {
			model.addAttribute("message", "회원 정보 수정 실패~~");
			model.addAttribute("url", "/user2/userUpdate?idx="+idx);
		}
		else if(msgFlag.equals("guestInputOk")) {
			model.addAttribute("message", "방명록에 글이 등록되었습니다.");
			model.addAttribute("url", "/guest/guestList");
		}
		else if(msgFlag.equals("guestInputNo")) {
			model.addAttribute("message", "방명록 글등록 실패~~");
			model.addAttribute("url", "/guest/guestInput");
		}
		else if(msgFlag.equals("adminOk")) {
			model.addAttribute("message", "관리자 인증 성공");
			model.addAttribute("url", "/guest/guestList");
		}
		else if(msgFlag.equals("adminNo")) {
			model.addAttribute("message", "관리자 인증 실패~~");
			model.addAttribute("url", "/guest/admin");
		}
		else if(msgFlag.equals("adminOut")) {
			model.addAttribute("message", "관리자 로그아웃");
			model.addAttribute("url", "/guest/guestList");
		}
		else if(msgFlag.equals("guestDeleteOk")) {
			model.addAttribute("message", "방명록 게시글이 삭제되었습니다.");
			model.addAttribute("url", "/guest/guestList");
		}
		else if(msgFlag.equals("guestDeleteNo")) {
			model.addAttribute("message", "방명록 게시글 삭제실패~~");
			model.addAttribute("url", "/guest/guestList");
		}
		else if(msgFlag.equals("memberJoinOk")) {
			model.addAttribute("msg", "회원에 가입되셨습니다.");
			model.addAttribute("url", "/member/memberLogin");
		}
		else if(msgFlag.equals("memberJoinNo")) {
			model.addAttribute("msg", "회원 가입 실패~~");
			model.addAttribute("url", "/member/memberJoin");
		}
		else if(msgFlag.equals("memberLoginOk")) {
			model.addAttribute("msg", mid+"님 로그인 되셨습니다.");
			model.addAttribute("url", "/member/memberMain");
		}
		else if(msgFlag.equals("memberLoginNo")) {
			model.addAttribute("msg", "로그인 실패~~");
			model.addAttribute("url", "/member/memberLogin");
		}
		else if(msgFlag.equals("memberLogout")) {
			model.addAttribute("msg", mid + "님 로그아웃 되셨습니다.");
			model.addAttribute("url", "/member/memberLogin");
		}

		
		return "include/message";
	}
	
}
