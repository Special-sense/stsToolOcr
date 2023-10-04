package edu.jeiu.ocr_pjt.controller;

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
	public ModelAndView locker_add(@RequestParam HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
//		원래 코드 -> 이거슨 현재 정보들을 food에 인설트하는것 그 후 food를 셀렉하고 ocrfood로 내보내는 과정 // 문제는 1개만 인설트됨 해야할일 -> 인설트 되는 과정중 왜 1개만 되는가 함 전부다 셀렉해보자
//		ocrService.insertAddLocker(param);
//
//		List<OcrDto> ocrFood = ocrService.getOcrFood(param);
//		modelAndView.addObject("ocrFood", ocrFood);
//		modelAndView.setViewName("locker");
		System.out.println(param+"네넘의 정체는 무성시냐");
	    String ocrFoodList = param.get("ocrFoodList");
		System.out.println(ocrFoodList+"네넘의 정체는 무성시123냐"); 
		
		
		modelAndView.setViewName("inputText");
		return modelAndView;
	}

	// locker관련 명령어 끝============================
	
	// edit 관련 명령어 ============================
	@RequestMapping("/edit_open")
	public ModelAndView edit_open(@RequestParam  HashMap<String, String> param) {

		ModelAndView modelAndView = new ModelAndView();
		List<OcrDto> ocrFood = ocrService.getEditOcrFood(param);
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
