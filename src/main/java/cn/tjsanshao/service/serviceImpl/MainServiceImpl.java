package cn.tjsanshao.service.serviceImpl;

import cn.tjsanshao.mapper.BagItemMapper;
import cn.tjsanshao.mapper.PlayerMapper;
import cn.tjsanshao.model.*;
import cn.tjsanshao.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Project:tower-server
 * @Description:main serviceImpl
 * @Author:TjSanshao
 * @Create:2019-05-05 22:49
 *
 **/
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private BagItemMapper bagItemMapper;

    @Override
    public Player getPlayerById(Integer id) {
        return null;
    }

    @Override
    public Player getPlayerByNameAndPassword(Player player) {
        return null;
    }

    @Override
    public boolean savePlayer(Player player) {

        // 状态设为1，正常
        player.setPlayerState(new Byte("1"));

        int row = playerMapper.insertSelective(player);

        if (row > 0) {
            return true;
        }

        return false;
    }

    @Override
    public boolean savePlayerAndAttributeAndPosAndScene(Player player, CharacterAttribute attribute, PlayerNowPosition position, PlayerNowScene scene) {
        return false;
    }

    @Override
    public boolean updatePlayerAndAttributeAndPosAndScene(Player player, CharacterAttribute attribute, PlayerNowPosition position, PlayerNowScene scene) {
        return false;
    }

    @Override
    public boolean deletePlayerById(Integer id) {
        return false;
    }

    @Override
    public List<BagItem> listAllItems() {
        return bagItemMapper.selectAll();
    }
}
