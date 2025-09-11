package com.spring.springGroupS.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.spring.springGroupS.vo.MemberVO;

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
	//파일 업로드후 서버에 구분처리해서 저장하기
	public String fileUpload(MultipartFile fName, String mid, String part) {
		// 파일명 중복처리
		String oFileName = fName.getOriginalFilename();
		String sFileName = mid + "_" + UUID.randomUUID().toString().substring(0, 4) + "_" + oFileName;
		
		try {
			//서버에 파일 구분처리하여 저장하기
			writeFile(fName, sFileName, part);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sFileName;
	}
	private void writeFile(MultipartFile fName, String sFileName, String part) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String realPath = request.getSession().getServletContext().getRealPath("/resources/data/"+part+"/");
		
		FileOutputStream fos = new FileOutputStream(realPath + sFileName);
		
		if(fName.getBytes().length != -1) {
			fos.write(fName.getBytes());
		}
		fos.flush();
		fos.close();
	}


}
