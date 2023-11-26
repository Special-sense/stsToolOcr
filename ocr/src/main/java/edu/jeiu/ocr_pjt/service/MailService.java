package edu.jeiu.ocr_pjt.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import edu.jeiu.ocr_pjt.dao.OcrDAO;
import edu.jeiu.ocr_pjt.dto.OcrDto;

@Service
public class MailService {

	@Autowired
	private MailSender mailSender;
	@Autowired
	private SqlSession sqlSession;
	
	public void sendEmail(String toAddress, String fromAddress,String subject, String msgBody) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(fromAddress);
		smm.setTo(toAddress);
		smm.setSubject(subject);
		smm.setText(msgBody);

    	
		mailSender.send(smm);
	}
	
	//DB에서 id에 맞는 음식들 추출하고 유통기한 오늘과 비교 후 유통기한 지난 음식들은 list에 담아서 다시 컨트롤러에 전송	
	public List<String> exdatefood(HashMap<String, String> param) {
	    // OcrDAO 객체 생성
	    OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);

	    // OcrDAO를 통해 데이터베이스에서 데이터 조회
	    List<OcrDto> getDBOcrFood = ocrDAO.getDBOcrFood(param);

	    // 오늘 날짜 구하기
	    Date today = new Date();

	    // 유통기한이 지난 음식들의 이름을 담을 리스트
	    List<String> expiredFoodNames = new ArrayList<>();

	    // 각 음식의 유통기한을 확인하여 지난 음식 이름 리스트에 추가
	    for (OcrDto food : getDBOcrFood) {
	        String expirystring = food.getExpirydate(); // 음식의 유통기한 가져오기
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date expiryDate = null;
	        
	        try {
	            expiryDate = dateFormat.parse(expirystring); // 문자열을 Date 객체로 변환
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        // 유통기한이 오늘보다 이전인 경우 해당 음식의 이름을 리스트에 추가
	        if (expiryDate != null && expiryDate.before(today)) {
	            expiredFoodNames.add(food.getFoodname()); // 음식 이름 추가
	        }
	    }

	    // 유통기한이 지난 음식들의 이름 리스트 반환
	    return expiredFoodNames;
	}
}