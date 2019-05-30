package cn.tjsanshao.service.serviceImpl;

import cn.tjsanshao.mapper.*;
import cn.tjsanshao.model.*;
import cn.tjsanshao.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PlayerNowPositionMapper playerNowPositionMapper;

    @Autowired
    private PlayerNowSceneMapper playerNowSceneMapper;

    @Autowired
    private PlayerItemMapper playerItemMapper;

    @Autowired
    private CharacterAttributeMapper characterAttributeMapper;

    @Autowired
    private PlayerSkillMapper playerSkillMapper;

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

    @Transactional
    @Override
    public boolean savePlayerBagAndSkill(Integer playerId, List<Integer> items, List<String> skills) {

        // 根据player_id清空player_item和player_skill表
        playerItemMapper.deleteByPlayer(playerId);
        playerSkillMapper.deleteByPlayer(playerId);

        if (items != null) {
            // 重新插入items新的数据
            for (int i = 0; i < items.size(); i++) {
                PlayerItem item = new PlayerItem();
                item.setPlayerId(playerId);
                item.setItemId(items.get(i));
                playerItemMapper.insertSelective(item);
            }
        }

        if (skills != null) {
            // 重新插入skills新的数据
            for (int i = 0; i < skills.size(); i++) {
                PlayerSkill skill = new PlayerSkill();
                skill.setPlayerId(playerId);
                skill.setSkill(skills.get(i));
                playerSkillMapper.insertSelective(skill);
            }
        }

        return true;
    }

    @Transactional
    @Override
    public boolean savePlayerBagAndSkill(Integer playerId, List<Integer> items, List<String> skills, float life, float coin) {

        CharacterAttribute characterAttribute = new CharacterAttribute();
        characterAttribute.setPlayerId(playerId);
        characterAttribute.setPlayerLife(life);
        characterAttribute.setPlayerCoin(coin);
        characterAttributeMapper.updateByPlayerSelective(characterAttribute);

        savePlayerBagAndSkill(playerId, items, skills);

        return true;
    }

    @Override
    public List<BagItem> listAllItems() {
        return bagItemMapper.selectAll();
    }

    @Override
    public PlayerNowPosition getPlayerPosition(Integer playerId) {
        return playerNowPositionMapper.selectByPlayer(playerId);
    }

    @Override
    public PlayerNowScene getPlayerNowScene(Integer playerId) {
        return playerNowSceneMapper.selectByPlayer(playerId);
    }

    @Override
    public List<PlayerItem> listPlayerItems(Integer playerId) {
        return playerItemMapper.selectByPlayer(playerId);
    }

    @Override
    public CharacterAttribute getCharacterAttribute(Integer playerId) {
        return characterAttributeMapper.selectByPlayer(playerId);
    }

    @Override
    public List<PlayerSkill> listPlayerSkill(Integer playerId) {
        return playerSkillMapper.selectByPlayer(playerId);
    }
}
