package cn.tjsanshao.mapper;

import cn.tjsanshao.model.PlayerNowScene;

public interface PlayerNowSceneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayerNowScene record);

    int insertSelective(PlayerNowScene record);

    PlayerNowScene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayerNowScene record);

    int updateByPrimaryKey(PlayerNowScene record);

    PlayerNowScene selectByPlayer(Integer playerId);
}