package cn.tjsanshao.mapper;

import cn.tjsanshao.model.PlayerSkill;

import java.util.List;

public interface PlayerSkillMapper {
    int insert(PlayerSkill record);

    int insertSelective(PlayerSkill record);

    List<PlayerSkill> selectByPlayer(Integer playerId);

    int deleteByPlayer(Integer playerId);
}