package com.spring.springGroupS.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class ProjectProvide {
	
	@Autowired
	JavaMailSender mailSender;	
	
	//mail보내기
	public String mailSend(
			String toMail,
			String title,
			String mailFlag
			) throws MessagingException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper  messageHelper = new MimeMessageHelper(message, true , "UTF-8");
		
		String content ="";
		messageHelper.setTo(toMail);
		messageHelper.setSubject(title);
		messageHelper.setText(content);
		
		//메시지 보관합(messageHelper)에 저장되는 content 변수안에 발신자의 필요한정보를 추가로 담아준다. 
		content = content.replace("\n", "<br>");
		content += "<br><hr><h3>SpringGroup에서 보냅니다</h3><hr><br>";
		content += "<font cilor='red'><b>"+mailFlag+"</b></font><br>";
		content += "<p><amg src=\"cid:main.jpg\" width='500px'></p>";
		content += "<p>방문하기 : <a href='http://49.142.157.251:9090/cjgreen'>SpringGroup</a></P>";
		content += "<hr>";
		messageHelper.setText(content, true);
		
		FileSystemResource file = new FileSystemResource(request.getSession().getServletContext().getRealPath("/resources/images/main.jpg"));
		messageHelper.addInline("main.jpg", file);
 
		mailSender.send(message);
		
		
		return "1";
		
	}	

}
