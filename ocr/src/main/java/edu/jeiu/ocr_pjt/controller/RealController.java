package edu.jeiu.ocr_pjt.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.jeiu.ocr_pjt.dto.OcrDto;
import edu.jeiu.ocr_pjt.service.OcrService;

@Controller
public class RealController {

	@Autowired
	private OcrService ocrService;

	// index관련 명령어들 =================================================
	// 목록 조회화면 Open
	@RequestMapping("/index_open")
	public ModelAndView index_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		return modelAndView;
	}

	// index관련 명령어 여기까지 =================================================

	// login 관련 명령어들 =================================================
	// 로그인 화면Open
	@RequestMapping("/login_open")
	public ModelAndView login_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;
	}

	// 로그인 시도
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam HashMap<String, String> param, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		boolean a = ocrService.logintry(param, session);

		// 로그인 성공시
		if (a) {
			modelAndView.setViewName("index");
		}
		// 로그인 실패시
		else {
			modelAndView.setViewName("login");
		}

		return modelAndView;
	}

	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		HttpSession session = request.getSession();
		session.invalidate();

		modelAndView.setViewName("index");

		return modelAndView;
	}

	// login끝-----------------------------------------------------------------
	// -----------------------------------------------------------------------

	// register 관련 명령어들 =================================================
	// 회원가입창 오픈
	@RequestMapping("/register_open")
	public ModelAndView register_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");

		return modelAndView;
	}

	// DB 회원가입 정보 입력
	@RequestMapping("/registerInsert")
	public ModelAndView registerInsert(@RequestParam HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
		ocrService.insertRegister(param);
		modelAndView.setViewName("login");

		return modelAndView;
	}

	// register끝-----------------------------------------------------------------
	// -----------------------------------------------------------------------

	// menu관련 명령어 ============================
	// 목록 조회화면 Open
	@RequestMapping("/list_open")
	public ModelAndView list_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ocr_list");

		return modelAndView;
	}

	// menu관련 명령어 여기까지 ============================

	// input 관련 명령어 ============================
	@RequestMapping("/inputText_open")
	public ModelAndView inputText_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inputText");

		return modelAndView;
	}

	// 체크박스 체크한 데이터 삭제
	@RequestMapping("/inputText_delete")
	public ModelAndView inputText_delete(@RequestParam List<String> checkbox, HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();

			for (String no : checkbox) {
				ocrService.deleteFoodlist(no);
			}
		List<OcrDto> ocrFoodList = ocrService.getOcrFoodList(param);
		modelAndView.addObject("ocrFoodList", ocrFoodList);
		modelAndView.setViewName("inputText");

		return modelAndView;
	}

	// input관련 명령어 끝 ============================

	// locker 관련 명령어 ============================
	@RequestMapping("/locker_open")
	public ModelAndView locker_open(@RequestParam  HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("locker");

		return modelAndView;
	}

	@RequestMapping("/locker_add")
	public ModelAndView locker_add(HttpServletRequest request)  {
		ModelAndView modelAndView = new ModelAndView();

		
		// 요청에서 모든 파라미터를 받아옵니다.
		Map<String, String[]> parameters = request.getParameterMap();

		List<String> nos = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		List<String> foodnames = new ArrayList<>();
		List<String> buydates = new ArrayList<>();
		List<String> expirydates = new ArrayList<>();

		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {

		    String paramName = entry.getKey();
		    String[] paramValues = entry.getValue();
		    // 파라미터 이름과 값을 출력
		    System.out.println(paramName + " = " + Arrays.toString(paramValues));

		    // 파라미터를 개별적으로 처리하는 예시
		    if ("no".equals(paramName)) {
		        // "no" 파라미터 처리
		        for (String value : paramValues) {
		        	nos.add(value);

		        }
		    } else if ("foodname".equals(paramName)) {
		        // "foodname" 파라미터 처리
		        for (String value : paramValues) {
		        	foodnames.add(value);

		        }
		    }
		    else if ("buydate".equals(paramName)) {
		        // "foodname" 파라미터 처리
		        for (String value : paramValues) {
		        	buydates.add(value);
		        }
		    }
		    else if ("expirydate".equals(paramName)) {
		        // "foodname" 파라미터 처리
		        for (String value : paramValues) {
		        	expirydates.add(value);	
		        }
		    }
		    else if ("id".equals(paramName)) {
		        // "foodname" 파라미터 처리
		        for (String value : paramValues) {
		        	ids.add(value);	
		        }
		    }

		}
		for (int i = 0; i < nos.size(); i++) {
			
			HashMap<String,String> param = new HashMap<>();
			param.put("no", nos.get(i));
			param.put("foodname", foodnames.get(i));
			param.put("buydate", buydates.get(i));
			param.put("expirydate", expirydates.get(i));
			param.put("id",ids.get(0));
			System.out.println(param+"나는 파람이야");
			ocrService.insertAddLocker(param);
		    System.out.println("id: " + ids.get(0));
		    System.out.println("nos: " + nos.get(i));
		    System.out.println("foodnames: " + foodnames.get(i));
		    System.out.println("buydates: " + buydates.get(i));
		    System.out.println("expirydates: " + expirydates.get(i));
		}
		
		HashMap<String,String> param = new HashMap<>();
		param.put("id",ids.get(0));
		List<OcrDto> ocrFood = ocrService.getOcrFood(param);
		System.out.println(ocrFood);



	    modelAndView.addObject("ocrFood", ocrFood);
		modelAndView.setViewName("locker");		
		

		return modelAndView;
	}

	// locker관련 명령어 끝============================
	
	// edit 관련 명령어 ============================
	@RequestMapping("/edit_open")
	public ModelAndView edit_open(@RequestParam  HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println(param);
		List<OcrDto> ocrFood = ocrService.getEditOcrFood(param);
		System.out.println("확인창"+ocrFood);
		modelAndView.addObject("ocrFood", ocrFood);
		modelAndView.setViewName("edit");

		return modelAndView;
	}



	// locker관련 명령어 끝============================
	
	
	
	

	// 입력
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
		ocrService.insertAdd(param);
//		modelAndView.addObject("mode", "auto");
		modelAndView.setViewName("ocr_view");

		return modelAndView;
	}

}
