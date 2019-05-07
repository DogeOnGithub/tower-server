package cn.tjsanshao.service;

import cn.tjsanshao.model.*;

import java.util.List;

public interface MainService {
    Player getPlayerById(Integer id);
    Player getPlayerByNameAndPassword(Player player);
    boolean savePlayer(Player player);
    boolean savePlayerAndAttributeAndPosAndScene(Player player, CharacterAttribute attribute, PlayerNowPosition position, PlayerNowScene scene);
    boolean updatePlayerAndAttributeAndPosAndScene(Player player, CharacterAttribute attribute, PlayerNowPosition position, PlayerNowScene scene);

    List<BagItem> listAllItems();

    PlayerNowPosition getPlayerPosition(Integer playerId);

    PlayerNowScene getPlayerNowScene(Integer playerId);

    List<PlayerItem> listPlayerItems(Integer playerId);

    CharacterAttribute getCharacterAttribute(Integer playerId);
}
