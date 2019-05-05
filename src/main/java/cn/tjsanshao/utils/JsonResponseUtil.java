package cn.tjsanshao.utils;

import com.alibaba.fastjson.JSON;

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

}
