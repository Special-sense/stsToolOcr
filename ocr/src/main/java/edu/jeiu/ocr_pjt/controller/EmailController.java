package edu.jeiu.ocr_pjt.controller;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.jeiu.ocr_pjt.dto.OcrDto;
import edu.jeiu.ocr_pjt.service.MailService;

@Controller
public class EmailController {
	
	@Autowired
	private MailService mailService;


	//DB작업이 필요한 만큼 DAO들 선언해야함
	
	//아이디와 이메일이 같으면 특정한 메일이 가게..
	@RequestMapping("/noticeMail")
	public ModelAndView sendEmail(String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		
	    // HashMap<String, String> 타입의 변수 생성후 id에 값 넣기
        HashMap<String, String> param = new HashMap<>();
        param.put("id", id);
        //유통기한이 지난 음식 가지고 오기 
		List<String> exdatefood = mailService.exdatefood(param);
		
		
		//메일 작성 
		String addr = "ocrprojectjeu@gmail.com";
		
		String subject = "[😀😀] 냉장고를 부탁해 알림메일 입니다.";

		String body = "안녕하세요? 냉장고를 부탁해 서비스 입니다\r\n 고객님의 "+exdatefood+"식품의 유통기한이 만료되어 메일 발송드립니다\r\n 감사합니다 오늘도 좋은하루 보내세요";
		
		mailService.sendEmail(id, addr, subject, body);
		 	
		mv.setViewName("ocr_list");
		return mv;
	}
}