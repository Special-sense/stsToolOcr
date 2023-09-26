package edu.jeiu.ocr_pjt.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.jeiu.ocr_pjt.infra.NaverOcrApi;
import edu.jeiu.ocr_pjt.service.OcrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequiredArgsConstructor
public class OcrController {
	
	
	@Autowired
	private OcrService ocrService ;
	
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
	    public String uploadAndOcr(@RequestParam("file") MultipartFile file, Model model) throws IOException {
	        if (file.isEmpty()) {
	        	System.out.println("비어있다");
	            return "error"; // 파일이 비어있을 경우 에러를 처리하는 HTML 템플릿으로 이동
	        }

	        System.out.println("시작하겠습니다");
	        
	        String naverSecretKey = secretKey; // 본인의 네이버 Clova OCR 시크릿 키로 대체

	        File tempFile = File.createTempFile("temp", file.getOriginalFilename());
	        file.transferTo(tempFile);

	        List<String> result = naverApi.callApi("POST", tempFile.getPath(), naverSecretKey, "jpg");

	        tempFile.delete(); // 임시 파일 삭제
	        System.out.println(result);
	        
	        ocrService.dateMod(result);
	        
	        model.addAttribute("ocrResult", result); // OCR 결과를 HTML 템플릿에 전달

	        
	        
	        return "ocr_view"; // OCR 결과를 표시하는 HTML 템플릿 이름 반환
	    }

	

}
