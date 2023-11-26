package edu.jeiu.ocr_pjt.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.jeiu.ocr_pjt.dto.OcrDto;

public interface OcrDAO {

	
	
	//로그인시 체크 메소드
	public OcrDto loginCheck(HashMap<String, String> param);
	

	
	//회원가입 insert 메소트
	public void insertRegisterDB(HashMap<String, String> param);

	// 사용자 냉장고 select 메소드
	public void selectfood(String param);
	
	// foollist 음식 날짜 입력DB 메소드 - insertfood
	public void insertfood(@Param("inputFood") String inputFood ,@Param("buydate") String buydate ,@Param("expirydate") String expirydate,@Param("id")String id);

	
	
	
	//유통기한자동설정 후 / 바로 조회
	public void updateExpiry(HashMap<String, String> param);
	public List<OcrDto> getDBOcrFoodList(HashMap<String, String> param);
	
	
	
	//냉장고에 넣은것들중 바로 삭제
	public void deleteFoodlistDB(String no);
	
	//foodList food에 데이터 입력  후 테이블 데이터 제거 

	public void insertAddLockerDB(HashMap<String, String> param);
	public void  delectFoodList();
	
	//locker에 food 테이블값 가지고 오기전 업테이트 후 가지고 오기
	public void updateFoodTable();
	public List<OcrDto> getDBOcrFood(HashMap<String, String> param);
	

	//locker에서 이름 기준으로 food 수정할 테이블값 가지고 오기 그리고 food에 있는 놈들 삭제
	public List<OcrDto> getDBEditOcrFood(HashMap<String, String> param);
	public void copyfoodtofoodlist(HashMap<String, String> param);
	//foodlist 넘버 초기화
	public void updateFoodlistTable();
	public void DeleteFoodTableName(HashMap<String, String> param);
	

	
	public void insertAddnull();
	// 실행 DB
	public void addDB(HashMap<String, String> param);
	
	//이메일 보낼 때 아이디만  조회
	public void selectId();

}
