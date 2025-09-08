show tables;

create table member (
  idx       int not null auto_increment,       /*고유번호*/
  mid       varchar(30) not null,              /*회원아이디 (중복 불허)*/
  pwd       varchar(100) not null,			       /*회원 비밀번호 (ㄴsha256암호화)*/
  nickName  varchar(20) not null,	             /*회원 병멸(중복불허 /수정가능)*/
  name		  varchar(20) not null,				       /*회원성명*/				
  gender    char(2)	not null default '남자',     /*회원 성별(남자,여자)*/
  birthday  datetime default now(),            /*회원 생일*/
  tel			  varchar(15),									     /*전화번호(010-1234-5678)*/
  address   varchar(100),                      /*주소(다음 API활용)-우변번호/주소/상제주소/참조주소*/
  email		  varchar(60) not null,              /*이메일주소 (아이디/비밀번호 분실시 이메일인증처리)-입력시 이메일형식 필수체크*/
  homePage  varchar(60),                       /*회원홈페이지 (블로그/인스타/페이스북)*/
  job			  varchar(20),                       /*직업*/  
  hobby		  varchar(100),                      /*취미 체크박스 (2개 이상이면 구분자는 '/'처리*/
  photo		  varchar(100) default 'noimage.jpg',/*회원 사진(초기가입시에 사진이 없으면 'noimage')*/
  content   text,                              /*저기회원 소개*/
  userInfor char(3) default '공개',              /*회원 정보 '공개/비공개'*/
  userDel   char(2)  default 'NO',             /*회원탈퇴 신청여부(no현재 활동중, ok탈퇴신청중->탈퇴후 한달동안 재가입 불가)*/ 
  point		  int default 100,                   /*회원 누적포인트(가입포인트 100점,1회방문시 10포인트증가,1일 최대방문 5회가지허용,물건 구매시 100당 1포인트)*/
  level     int default 3,                     /*회원 등급(0;관리자,1:우수회원,2:정회원,3:준회원,999:탈퇴신천회원)*/
  visitCnt  int default 0,                     /*총 방문횟수*/
  todayCnt  int default 0,                     /*오늘 방문횟수*/
  startDate datetime default now(),            /*최초 가입일()*/
  lastDate  datetime default now(),            /*마지막 접속일/탈퇴일*/
  primary key (idx),
  unique(mid)
);