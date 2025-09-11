<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>memberMain.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container">
  <h2>회원 전용방</h2>
  <hr/>
  <div class="row">
  <div class="col">
    현재 회원 등급 : ${strLevel}<br/>
    총 방문횟수 : ${mVo.visitCnt}<br/>
    오늘 방문횟수 : ${mVo.todayCnt}<br/>
    현재 가용 포인트 : ${mVo.point}<br/>
    최종 방문일 : ${mVo.lastDate}<br/>
  </div>
  <div class="col">
    <img src="${ctp}/member/${mVo.photo}" width="200px"/>
  </div>
  </div>
  <hr/>
	<div>
	  방명록 올린 글수 : ${guestCnt}<br/>
	</div>  
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>