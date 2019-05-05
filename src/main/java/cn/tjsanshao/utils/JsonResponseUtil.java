package cn.tjsanshao.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/*
 * @Project:tower-server
 * @Description:json tools
 * @Author:TjSanshao
 * @Create:2019-05-05 21:42
 *
 **/
public class JsonResponseUtil {

    public static String transferJSON(Object  object) {
        String jsonString = JSON.toJSONString(object);
        return jsonString;
    }

    public static String transferToJSONResponse(String state, String message, Object object) {
        Map<String, Object> response = new HashMap<>();
        response.put("state", state);
        response.put("message", message);
        response.put("data", object);
        return JSON.toJSONString(response);
    }

}
