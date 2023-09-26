package edu.jeiu.ocr_pjt.dao;

import java.util.HashMap;
import java.util.List;

public interface OcrDAO {

	


	// 사용자 냉장고 select 메소드
	public void selectfood(String param);
	
	// 입력DB 메소드 - insertfood
	public void insertfood(String param);

	// 실행 DB
	public void addDB(HashMap<String, String> param);
	

}
