package edu.jeiu.ocr_pjt.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jeiu.ocr_pjt.dao.OcrDAO;
import edu.jeiu.ocr_pjt.dto.OcrDto;

@Transactional
@Service("OcrServicelmpl")
public class OcrServicelmpl implements OcrService {
	
	

	@Autowired
	private SqlSession sqlSession;

	// 입력 메소드
//	@Transactional
	@Override
	public void insertAdd(HashMap<String, String> param) {

		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);

		ocrDAO.addDB(param);

	}
	
	//로그인시
	@Override
	public boolean logintry( HashMap<String, String> param , HttpSession session)  {
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		OcrDto ocrDto = ocrDAO.loginCheck(param);
		boolean a = true;

		
	    if(ocrDto != null){
	    	  //로그인 성공시
	    	  session.setAttribute("id", ocrDto.getId());
			  a = true;
		}else{	  
	    	JOptionPane.showMessageDialog(null, "비밀번호 혹은 아이디를 확인해주세요");
			  a = false;
		}
		return a;
	    
	}
	
	//회원가입시
	@Override
	public void insertRegister(HashMap<String, String> param) {

		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		ocrDAO.insertRegisterDB(param);
		

		
		

		
	}
	
	
	
	
	//임시로 데이터 가지고 오기
	@Override
	public List<OcrDto> getOcrFoodList(HashMap<String, String> param) {

		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		
		//foodlis에서 유통기한 자동 설정
		ocrDAO.updateExpiry(param);
		
		List<OcrDto> getOcrFoodList = ocrDAO.getDBOcrFoodList(param);

		
		
		return getOcrFoodList;
		
	}
	
	//체크박스 한 데이터 삭제
	@Override
	public void deleteFoodlist(String no) {
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		List<String> list = new ArrayList<>();
		list.add(no);
		ocrDAO.deleteFoodlistDB(no);
		System.out.println(list);
		

	}
	
	//loker에 db 입력
	public void insertAddLocker(HashMap<String, String> param) {
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		
		//food에 데이터 입력
		ocrDAO.insertAddLockerDB(param);
		//foodlist 데이터 제거
		ocrDAO.delectFoodList();
	

		
	}
	
	//locker에 food 테이블값 가지고 오기
	@Override
	public List<OcrDto> getOcrFood(HashMap<String, String> param) {
		
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		
		ocrDAO.updateFoodTable();
		List<OcrDto> getOcrFood = ocrDAO.getDBOcrFood(param);

		
		
		return getOcrFood;
		
	}
	//locker에 food 수정할 테이블값 가지고 오기
	public List<OcrDto> getEditOcrFood(HashMap<String, String> param){
		
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		
		//food -> foodlist 이동
		ocrDAO.copyfoodtofoodlist(param);
		//foodlist no update 
		ocrDAO.updateFoodlistTable();
		
		//foodlist에서 가지고 오기
		List<OcrDto> getDBOcrFoodList = ocrDAO.getDBOcrFoodList(param);

		
		//가지고 오고 삭제하기
		ocrDAO.DeleteFoodTableName(param);
		
		
		return getDBOcrFoodList;
		
	}
	

	
	//edit에서 db에 정보 추가를 위해 null값1 건 입력
	public void editadd(HashMap<String, String> param){
		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);
		
		//foodlist에 null값 한건 데이터 입력
		ocrDAO.insertAddnull();


		
	}
	
	//데이터 음식만 추출

	@Override
	public void dateMod(List<String> param , String id) {
		
		System.out.println("실험 시작");
		System.out.println(param);

		OcrDAO ocrDAO = sqlSession.getMapper(OcrDAO.class);

		// 공백 제거
		List<String> mList = new ArrayList<>();

		for (String str : param) {
			String modifiedStr = str.replaceAll("\\s", ""); // 공백을 제거
			mList.add(modifiedStr);
		}

		// 공백 제거완료 앞부분 제거 시작
		System.out.println("금액 까지의 범위" + mList.indexOf("금액"));
		int findex = mList.indexOf("금액");
//	      int lindex = mList.indexOf("과세");
		for (int i = 0; i <= findex; i++) {
			mList.remove(0);
		}

		System.out.println("삭제까지 완료" + mList);
		// 앞부분 제거 완료 이제 물품 쪼개기 시작

		// 물품 쪼갤때 사용하는 번호 w

		List<String> countNumber = new ArrayList<>();

		int index1 = mList.indexOf("01");
		countNumber.add(String.valueOf(index1));
		int index2 = mList.indexOf("02");
		countNumber.add(String.valueOf(index2));
		int index3 = mList.indexOf("03");
		countNumber.add(String.valueOf(index3));
		int index4 = mList.indexOf("04");
		countNumber.add(String.valueOf(index4));
		int index5 = mList.indexOf("05");
		countNumber.add(String.valueOf(index5));
		int index6 = mList.indexOf("06");
		countNumber.add(String.valueOf(index6));
		int index7 = mList.indexOf("07");
		countNumber.add(String.valueOf(index7));
		int index8 = mList.indexOf("08");
		countNumber.add(String.valueOf(index8));
		int index9 = mList.indexOf("09");
		countNumber.add(String.valueOf(index9));
		int index10 = mList.indexOf("10");
		countNumber.add(String.valueOf(index10));
		int index11 = mList.indexOf("11");
		countNumber.add(String.valueOf(index11));

		// 끝 번호 검색
		int find = 10;
		System.out.println(countNumber +"몇까지 있는지 리스트");
		
		for (int i = 0; i <= 11; i++) {

			String value = countNumber.get(i);
			int intValue = Integer.parseInt(value); // 문자열을 정수로 변환

			if (intValue == -1) {
				//여기 수정
				countNumber.add(i, String.valueOf(mList.indexOf("과세")));
				find = i;
				break;
			}
		}
		
		System.out.println(countNumber);
		
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();

		// 문자열 추가
		StringBuilder List1 = new StringBuilder();
		String inputFood = "";
		String buydate = "";
		String expirydate = "";
		

		if (find > 0) {

			for (int i = Integer.parseInt(countNumber.get(0)) + 1; i < Integer.parseInt(countNumber.get(1)) - 3; i++) {
				List1.append(mList.get(i));
			}

			inputFood = List1.toString();
			buydate = now.toString();
			expirydate = now.toString();
			System.out.println(buydate+"첫번째물품" + inputFood+expirydate+"아이디는 ="+id);
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);


		}

		StringBuilder List2 = new StringBuilder();
		if (find > 1) {

			for (int i = Integer.parseInt(countNumber.get(1)) + 1; i < Integer.parseInt(countNumber.get(2)) - 3; i++) {
				List2.append(mList.get(i));
			}
			
			inputFood = List2.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("두번째물품" + inputFood);
		}

		StringBuilder List3 = new StringBuilder();
		if (find > 2) {

			for (int i = Integer.parseInt(countNumber.get(2)) + 1; i < Integer.parseInt(countNumber.get(3)) - 3; i++) {
				List3.append(mList.get(i));
			}
			
			inputFood = List3.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("세번째물품" + inputFood);
		}

		StringBuilder List4 = new StringBuilder();
		if (find > 3) {

			for (int i = Integer.parseInt(countNumber.get(3)) + 1; i < Integer.parseInt(countNumber.get(4)) - 3; i++) {
				List4.append(mList.get(i));
			}
			
			inputFood = List4.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("네번째물품" + inputFood);
		}

		StringBuilder List5 = new StringBuilder();
		if (find > 4) {

			for (int i = Integer.parseInt(countNumber.get(4)) + 1; i < Integer.parseInt(countNumber.get(5)) - 3; i++) {
				List5.append(mList.get(i));
			}
			
			inputFood = List5.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("다섯번째물품" + inputFood);
		}

		StringBuilder List6 = new StringBuilder();
		if (find > 5) {

			for (int i = Integer.parseInt(countNumber.get(5)) + 1; i < Integer.parseInt(countNumber.get(6)) - 3; i++) {
				List6.append(mList.get(i));
			}
			
			inputFood = List6.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("여섯번째물품" + inputFood);
		}

		StringBuilder List7 = new StringBuilder();
		if (find > 6) {

			for (int i = Integer.parseInt(countNumber.get(6)) + 1; i < Integer.parseInt(countNumber.get(7)) - 3; i++) {
				List7.append(mList.get(i));
			}
			
			inputFood = List7.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("일곱번째물품" + inputFood);
		}

		StringBuilder List8 = new StringBuilder();
		if (find > 7) {

			for (int i = Integer.parseInt(countNumber.get(7)) + 1; i < Integer.parseInt(countNumber.get(8)) - 3; i++) {
				List8.append(mList.get(i));
			}
			
			inputFood = List8.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("여덟번째물품" + inputFood);
		}

		StringBuilder List9 = new StringBuilder();
		if (find > 8) {

			for (int i = Integer.parseInt(countNumber.get(8)) + 1; i < Integer.parseInt(countNumber.get(9)) - 3; i++) {
				List9.append(mList.get(i));
			}
			
			inputFood = List9.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("아홉번째물품" + inputFood);
		}

		StringBuilder List10 = new StringBuilder();
		if (find > 9) {

			for (int i = Integer.parseInt(countNumber.get(9)) + 1; i < Integer.parseInt(countNumber.get(10)) - 3; i++) {
				List10.append(mList.get(i));
			}
			
			inputFood = List10.toString();
			ocrDAO.insertfood(inputFood,buydate,expirydate,id);
			System.out.println("열번째물품" + inputFood);

		}

	}

}
