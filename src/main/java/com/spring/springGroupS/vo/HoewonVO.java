package com.spring.springGroupS.vo;

import lombok.Data;

//@Getter
//@Setter
//@ToString
//@Data=Getter+Setter+ToString(부트에서 생성자를 사용하기 때문에 지향하지 않는다(에러)/지금은 사용가능) -->스프링부트에서
//@AllArgsConstructor-전체생성자 -->스프링부트에서
//@NoArgsConstructor--기본생성자 -->스프링부트에서
//@Builder
@Data
public class HoewonVO {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	
	
	private String nickName;
	private String strGender;
}
