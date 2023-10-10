package edu.jeiu.ocr_pjt.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.jeiu.ocr_pjt.dto.OcrDto;

public interface OcrService {

	public void insertAdd(HashMap<String, String> param);
	

	public void dateMod(List<String> param , String id);
	
	public List<OcrDto> getOcrFoodList(HashMap<String, String> param);

	
	//로그인
	public boolean logintry( HashMap<String, String> param , HttpSession session);
	
	
	//회원가입
	public void insertRegister(HashMap<String, String> param);

	
	//체크박스 삭제
	public void deleteFoodlist(String no);
	
	//loker에 db입력
	public void insertAddLocker(HashMap<String, String> param) ;
	
	//locker에 food 테이블값 가지고 오기
	public List<OcrDto> getOcrFood(HashMap<String, String> param);

	//locker에 food 수정할 테이블값 가지고 오기
	public List<OcrDto> getEditOcrFood(HashMap<String, String> param);
	
}
