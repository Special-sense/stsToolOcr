package edu.jeiu.ocr_pjt.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.jeiu.ocr_pjt.dto.OcrDto;
import edu.jeiu.ocr_pjt.infra.NaverOcrApi;
import edu.jeiu.ocr_pjt.service.OcrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OcrController {

	@Autowired
	private OcrService ocrService;

	@Value("${naver.service.secretKey}")
	private String secretKey;
	private final NaverOcrApi naverApi;

	// 파일 업로드 폼을 보여주기 위한 GET 요청 핸들러 메서드
	@GetMapping("/upload-form")
	public String uploadForm() throws Exception {
		return "/upload-form"; // HTML 템플릿의 이름을 반환 (upload-form.html)
	}

	// 파일 업로드 및 OCR 수행을 위한 POST 요청 핸들러 메서드
	@RequestMapping("/uploadAndOcr")
	public ModelAndView uploadAndOcr(@RequestParam("file") MultipartFile file, Model model , HashMap<String , String> param , @RequestParam("id")String id) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
	        if (file.isEmpty()) {
	        	System.out.println("비어있다");
//	            //return "error"; // 파일이 비어있을 경우 에러를 처리하는 HTML 템플릿으로 이동
	        }

	        System.out.println("시작하겠습니다");
	        
	        String naverSecretKey = secretKey; // 본인의 네이버 Clova OCR 시크릿 키로 대체

	        File tempFile = File.createTempFile("temp", file.getOriginalFilename());
	        file.transferTo(tempFile);

	        List<String> result = naverApi.callApi("POST", tempFile.getPath(), naverSecretKey, "jpg");

	        tempFile.delete(); // 임시 파일 삭제
	        System.out.println(result);

		// 테스트용
//		List<String> result = new ArrayList<>();
//		result.add("1");
//		result.add("이,마트");
//		result.add("청계천점(02)2290-1234");
//		result.add("emart");
//		result.add("206-86-50913");
//		result.add("이갑수");
//		result.add("서울시");
//		result.add("중구");
//		result.add("금 액");
//		result.add("01");
//		result.add("(G)치킨");
//		result.add("너겟");
//		result.add("1kg");
//		result.add("10,500");
//		result.add("1");
//		result.add("10,500");
//		result.add("02");
//		result.add("용가리치킨520+140");
//		result.add("8,550");
//		result.add("1");
//		result.add("8,550");
//		result.add("03");
//		result.add("대림");
//		result.add("133,000");
//		result.add("2");
//		result.add("133,000");
//		result.add("과세");
//		result.add("물품");
//		result.add("37,109");
//		result.add("부");


		ocrService.dateMod(result, id);
		model.addAttribute("ocrResult", result); // OCR 결과를 HTML 템플릿에 전달
		
		List<OcrDto> ocrFoodList = ocrService.getOcrFoodList(param);
		modelAndView.addObject("ocrFoodList", ocrFoodList);
		modelAndView.setViewName("inputText");

		return modelAndView; // OCR 결과를 표시하는 HTML 템플릿 이름 반환
	}

}
