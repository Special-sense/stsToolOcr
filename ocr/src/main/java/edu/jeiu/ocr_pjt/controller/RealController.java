package edu.jeiu.ocr_pjt.controller;

import java.util.HashMap;

import org.omg.CORBA.UserException;
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
	
	// 목록 조회화면 Open
	@RequestMapping("/list_open")
	public ModelAndView list_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ocr_list");
		
		return modelAndView;
	}
	
	// 목록 조회화면 Open
	@RequestMapping("/view_open")
	public ModelAndView view_open() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ocr_view");
		
		return modelAndView;
	}
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
