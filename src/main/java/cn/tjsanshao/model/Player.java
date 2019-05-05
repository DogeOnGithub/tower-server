package cn.tjsanshao.model;

import lombok.Data;

@Data
public class Player {
    private Integer id;

    private String playerName;

    private String playerPassword;

    private Byte playerState;
}