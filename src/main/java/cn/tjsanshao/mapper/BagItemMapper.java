package cn.tjsanshao.mapper;

import cn.tjsanshao.model.BagItem;

import java.util.List;

public interface BagItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BagItem record);

    int insertSelective(BagItem record);

    BagItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BagItem record);

    int updateByPrimaryKey(BagItem record);

    List<BagItem> selectAll();
}