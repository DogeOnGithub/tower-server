package cn.tjsanshao.mapper;

import cn.tjsanshao.model.CharacterAttribute;

public interface CharacterAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CharacterAttribute record);

    int insertSelective(CharacterAttribute record);

    CharacterAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CharacterAttribute record);

    int updateByPrimaryKey(CharacterAttribute record);

    CharacterAttribute selectByPlayer(Integer playerId);

    int updateByPlayerSelective(CharacterAttribute record);
}