package edu.jeiu.ocr_pjt.infra;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import edu.jeiu.ocr_pjt.utill.JsonUtill;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@PropertySource("classpath:/application.properties")
public class NaverOcrApi {
	
	
		@Value("${naver.service.url}")
		private String url;
		
	   /**
	     * �꽕�씠踰� ocr api �샇異쒗븳�떎
	     * @param {string} type �샇異� 硫붿꽌�뱶 ���엯
	     * @param {string} filePath �뙆�씪 寃쎈줈
	     * @param {string} naver_secretKey �꽕�씠踰� �떆�겕由욱궎 媛�
	     * @param {string} ext �솗�옣�옄
	     * @returns {List} 異붿텧 text list
	     */
	   
	   public  List<String> callApi(String type, String filePath, String naver_secretKey, String ext) {
	        System.out.println("�븯�븯�뿬湲곌퉴吏� �솓�떎 :");

		   	String apiURL = url;
	        String secretKey = naver_secretKey;
	        String imageFile = filePath;
	        List<String> parseData = null;
	        
//	        log.info("callApi Start!");

	        System.out.println("callApi �떆�옉!");
	        try {
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setUseCaches(false);
	            con.setDoInput(true);
	            con.setDoOutput(true);
	            con.setReadTimeout(30000);
	            con.setRequestMethod(type);
	            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
	            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	            con.setRequestProperty("X-OCR-SECRET", secretKey);

	            JSONObject json = new JSONObject();
	            json.put("version", "V2");
	            json.put("requestId", UUID.randomUUID().toString());
	            json.put("timestamp", System.currentTimeMillis());
	            JSONObject image = new JSONObject();
	            image.put("format", ext);
	            image.put("name", "demo");
	            JSONArray images = new JSONArray();
	            // add -> put 蹂�寃�
	            images.put(image);
	            json.put("images", images);
	            String postParams = json.toString();

	            con.connect();
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            File file = new File(imageFile);
	            writeMultiPart(wr, postParams, file, boundary);
	            wr.close();

	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if (responseCode == 200) {
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();

		        System.out.println("데이터 : "+response);
	            parseData = jsonparse(response);
	            
		        System.out.println("API끝");


	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	        
	   return parseData;
	   } 
	   
	   /**
	     * writeMultiPart
	     * @param {OutputStream} out �뜲�씠�꽣瑜� 異쒕젰
	     * @param {string} jsonMessage �슂泥� params
	     * @param {File} file �슂泥� �뙆�씪
	     * @param {String} boundary 寃쎄퀎
	     */
	    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	            IOException {
	    	
            
	        System.out.println("�뜲�씠�뵲 泥섎━ 吏꾩엯");
	        StringBuilder sb = new StringBuilder();
	        sb.append("--").append(boundary).append("\r\n");
	        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
	        sb.append(jsonMessage);
	        sb.append("\r\n");

	        out.write(sb.toString().getBytes("UTF-8"));
	        out.flush();
	        
	        if (file != null && file.isFile()) {
	            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
	            StringBuilder fileString = new StringBuilder();
	            fileString
	                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
	            fileString.append("\"" + file.getName() + "\"\r\n");
	            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
	            out.write(fileString.toString().getBytes("UTF-8"));
	            out.flush();

	            try (FileInputStream fis = new FileInputStream(file)) {
	                byte[] buffer = new byte[8192];
	                int count;
	                while ((count = fis.read(buffer)) != -1) {
	                    out.write(buffer, 0, count);
	                }
	                out.write("\r\n".getBytes());
	            }

	            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
	        }
	        System.out.println("�뜲�씠�꽣 泥섎━ �걹");
	        out.flush();
	    }
	    /**
	     * �뜲�씠�꽣 媛�怨�
	     * @param {StringBuffer} response �쓳�떟媛�
	     * @returns {List} result text list
	     */
	    
	    
	    private static List<String> jsonparse(StringBuffer response) throws ParseException,JsonProcessingException {
            
	        System.out.println("�젣�씠�벖�뙆�뵿吏꾩엯");
	    	ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode = objectMapper.readTree(response.toString());

	        JsonNode imagesNode = rootNode.get("images").get(0);
	        JsonNode fieldsNode = imagesNode.get("fields");

	        List<String> result = new ArrayList<>();
	        for (JsonNode fieldNode : fieldsNode) {
	//        	result.add("\n");
	            result.add(fieldNode.get("inferText").asText());
	        }
            
	        System.out.println("�젣�씠�벖�걹");
	        return result;
	    } 

}
