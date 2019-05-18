package cn.tjsanshao.mapper;

import cn.tjsanshao.model.PlayerItem;

import java.util.List;

public interface PlayerItemMapper {
    int insert(PlayerItem record);

    int insertSelective(PlayerItem record);

    List<PlayerItem> selectByPlayer(Integer playerId);

    int deleteByPlayer(Integer playerId);
}