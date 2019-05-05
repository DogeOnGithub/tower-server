package cn.tjsanshao.model;

import lombok.Data;

@Data
public class CharacterAttribute {
    private Integer id;

    private Integer playerId;

    private Float playerLife;

    private Float playerCoin;
}