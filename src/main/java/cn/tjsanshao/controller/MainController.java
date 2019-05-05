package cn.tjsanshao.controller;

import cn.tjsanshao.model.Player;
import cn.tjsanshao.service.MainService;
import cn.tjsanshao.utils.JsonResponseUtil;
import cn.tjsanshao.utils.ResponseStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/*
 * @Project:tower-server
 * @Description:main controller
 * @Author:TjSanshao
 * @Create:2019-05-05 22:33
 *
 **/
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    // 注册
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String register(Player player) {

        if (StringUtils.isEmpty(player.getPlayerName()) || StringUtils.isEmpty(player.getPlayerPassword())) {
            return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_FAIL, ResponseStrings.MESSAGE_FAIL, null);
        }
        boolean result = mainService.savePlayer(player);
        if (!result) {
            return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_FAIL, ResponseStrings.MESSAGE_FAIL, null);
        }

        return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_SUCCESS, ResponseStrings.MESSAGE_SUCCESS, null);
    }

    // 登录
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Player player) {
        if (StringUtils.isEmpty(player.getPlayerName()) || StringUtils.isEmpty(player.getPlayerPassword())) {
            return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_FAIL, ResponseStrings.MESSAGE_FAIL, null);
        }
        Player result = mainService.getPlayerByNameAndPassword(player);
        if (result == null) {
            return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_FAIL, ResponseStrings.MESSAGE_FAIL, null);
        }

        return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_SUCCESS, ResponseStrings.MESSAGE_SUCCESS, null);
    }

    // 获取所有物品
    @RequestMapping(value = "/items", method = {RequestMethod.GET, RequestMethod.POST})
    public String allBagItems() {
        return JsonResponseUtil.transferJSON(mainService.listAllItems());
    }

}
