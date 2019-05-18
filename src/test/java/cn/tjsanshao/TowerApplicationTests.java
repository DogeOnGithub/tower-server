package cn.tjsanshao;

import cn.tjsanshao.mapper.PlayerMapper;
import cn.tjsanshao.mapper.PlayerNowSceneMapper;
import cn.tjsanshao.mapper.PlayerSkillMapper;
import cn.tjsanshao.model.Player;
import cn.tjsanshao.model.PlayerNowScene;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TowerApplicationTests {

	@Autowired
	private PlayerMapper playerMapper;

	@Autowired
	private PlayerNowSceneMapper playerNowSceneMapper;

	@Autowired
	private PlayerSkillMapper playerSkillMapper;

	@Test
	public void contextLoads() {
	}

	@Ignore
	@Test
	public void testPlayerMapper() {
		Player player = new Player();
		player.setPlayerName("TjSanshao");
		player.setPlayerPassword("TjSanshao");
		player.setPlayerState(new Byte("1"));
		System.out.println(playerMapper.insertSelective(player));
	}

	@Test
	public void testPlayerMapperSelect() {
		System.out.println(playerMapper.selectByPrimaryKey(1));
	}

	@Test
	public void testPlayerNowSceneMapper() {
		System.out.println(playerNowSceneMapper.selectByPrimaryKey(1));
	}

	@Test
	public void testPlayerSKillMapper() {
		System.out.println(playerSkillMapper.selectByPlayer(1));
	}
}
