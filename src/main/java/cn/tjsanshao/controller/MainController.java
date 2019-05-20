package cn.tjsanshao.controller;

import cn.tjsanshao.model.Player;
import cn.tjsanshao.service.MainService;
import cn.tjsanshao.utils.JsonResponseUtil;
import cn.tjsanshao.utils.ResponseStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    // 获取所有物品，用户物品系统的初始化
    @RequestMapping(value = "/items", method = {RequestMethod.GET, RequestMethod.POST})
    public String allBagItems() {
        return JsonResponseUtil.transferJSON(mainService.listAllItems());
    }

    // 获取主角当前位置
    @RequestMapping(value = "/position", method = {RequestMethod.GET, RequestMethod.POST})
    public String position(Integer player) {
        return JsonResponseUtil.transferJSON(mainService.getPlayerPosition(player));
    }

    // 获取主角所在的关卡
    @RequestMapping(value = "/scene", method = {RequestMethod.GET, RequestMethod.POST})
    public String scene(Integer player) {
        return JsonResponseUtil.transferJSON(mainService.getPlayerNowScene(player));
    }

    // 获取主角的物品
    @RequestMapping(value = "/my_items", method = {RequestMethod.GET, RequestMethod.POST})
    public String playerItems(Integer player) {
        return JsonResponseUtil.transferJSON(mainService.listPlayerItems(player));
    }

    // 获取主角的属性
    @RequestMapping(value = "/attribute", method = {RequestMethod.GET, RequestMethod.POST})
    public String attribute(Integer player) {
        return JsonResponseUtil.transferJSON(mainService.getCharacterAttribute(player));
    }

    // 获取主角的技能
    @RequestMapping(value = "/skills", method = {RequestMethod.GET, RequestMethod.POST})
    public String skills(Integer player) {
        return JsonResponseUtil.transferJSON(mainService.listPlayerSkill(player));
    }

    // 保存技能以及背包
    @RequestMapping(value = "/saveSkillAndBag", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveSkillAndBag(@RequestParam("player") Integer player, @RequestParam("item") List<Integer> items, @RequestParam("skill") List<String> skills, @RequestParam("life") float life, @RequestParam("coin") float coin) {
        boolean result = mainService.savePlayerBagAndSkill(player, items, skills, life, coin);
        if (result) {
            return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_SUCCESS, ResponseStrings.MESSAGE_SUCCESS, null);
        }
        return JsonResponseUtil.transferToJSONResponse(ResponseStrings.STATE_FAIL, ResponseStrings.MESSAGE_FAIL, null);
    }

}
