package cn.tjsanshao.mapper;

import cn.tjsanshao.model.PlayerNowPosition;

public interface PlayerNowPositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayerNowPosition record);

    int insertSelective(PlayerNowPosition record);

    PlayerNowPosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayerNowPosition record);

    int updateByPrimaryKey(PlayerNowPosition record);

    PlayerNowPosition selectByPlayer(Integer playerId);
}