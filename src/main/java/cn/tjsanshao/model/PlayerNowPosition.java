package cn.tjsanshao.model;

import lombok.Data;

@Data
public class PlayerNowPosition {
    private Integer id;

    private Float x;

    private Float y;

    private Float z;

    private Integer playerId;
}