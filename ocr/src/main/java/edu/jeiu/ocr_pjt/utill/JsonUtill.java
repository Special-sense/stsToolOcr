package edu.jeiu.ocr_pjt.utill;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class JsonUtill {
    /**
     * JSONObject => Map<String, String>
     * @param {JSONObject} jsonObject
     * @returns {Map} map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObject) {
        Map<String, Object> map = null;
        try {
        	
            map = new ObjectMapper().readValue(jsonObject.toString(), Map.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * JSONArray => List<Map<String, String>>
     * @param {jsonArray} jsonArray
     * @returns {List} list
     */
    public static List<Map<String, Object>> getListMapFromJsonArray(JSONArray jsonArray) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (jsonArray != null) {

        	int jsonSize = jsonArray.length();

            for (int i = 0; i < jsonSize; i++) {

                Map<String, Object> map = getMapFromJsonObject((JSONObject)jsonArray.get(i));
                list.add(map);

            }
        }
        return list;
    }
}
