package edu.jeiu.ocr_pjt.service;

import java.util.HashMap;
import java.util.List;

import edu.jeiu.ocr_pjt.dto.OcrDto;

public interface OcrService {

	public void insertAdd(HashMap<String, String> param);
	

	public void dateMod(List<String> param);
	
	public List<OcrDto> getOcrFoodList(HashMap<String, String> param);

	
	//로그인
	public boolean logintry( HashMap<String, String> param);
	
	
	//회원가입
	public void insertRegister(HashMap<String, String> param);


}
