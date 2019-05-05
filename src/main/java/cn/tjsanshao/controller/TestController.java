package cn.tjsanshao.controller;

import cn.tjsanshao.utils.JsonResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * @Project:tower-server
 * @Description:test controller
 * @Author:TjSanshao
 * @Create:2019-05-05 21:38
 *
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        Map<String, Object> result = new HashMap<>();
        result.put("state", "success");
        result.put("message", "success");
        return JsonResponseUtil.transferJSON(result);
    }

}
