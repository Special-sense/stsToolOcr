package edu.jeiu.ocr_pjt.dao;

import java.util.HashMap;
import java.util.List;

import edu.jeiu.ocr_pjt.dto.OcrDto;

public interface OcrDAO {

	
	
	//로그인시 체크 메소드
	public OcrDto loginCheck(HashMap<String, String> param);
	

	
	//회원가입 insert 메소트
	public void insertRegisterDB(HashMap<String, String> param);

	// 사용자 냉장고 select 메소드
	public void selectfood(String param);
	
	// 입력DB 메소드 - insertfood
	public void insertfood(String param);
	
	//냉장고에 넣은 후 바로 조회
	public List<OcrDto> getDBOcrFoodList(HashMap<String, String> param);

	// 실행 DB
	public void addDB(HashMap<String, String> param);
	

}
