package edu.jeiu.ocr_pjt.controller;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import edu.jeiu.ocr_pjt.service.OcrService;

@Controller
public class RealController {
	
	@Autowired
	private OcrService ocrService ;
	
	//index관련 명령어들 =================================================
	// 목록 조회화면 Open
	@RequestMapping("/index_open")
	public ModelAndView index_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	//index관련 명령어 여기까지 =================================================
	
	//login 관련 명령어들 =================================================
	// 목록 조회화면 Open
	@RequestMapping("/login_open")
	public ModelAndView login_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
	
	//login끝-----------------------------------------------------------------
	//-----------------------------------------------------------------------
	
	
	
	
	//register 관련 명령어들 =================================================
	@RequestMapping("/register_open")
	public ModelAndView register_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		
		return modelAndView;
	}
	@RequestMapping("/registerInsert")
	public ModelAndView registerInsert() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		
		return modelAndView;
	}

	
	//register끝-----------------------------------------------------------------
	//-----------------------------------------------------------------------
	
	
	
	// menu관련 명령어 ============================
	// 목록 조회화면 Open
	@RequestMapping("/list_open")
	public ModelAndView list_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ocr_list");
		
		return modelAndView;
	}
	
	// menu관련 명령어 여기까지 ============================
	
	// input관련 명령어 ============================
	@RequestMapping("/view_open")
	public ModelAndView view_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ocr_view");
		
		return modelAndView;
	}
	
	// input관련 명령어 ============================
	
	
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
