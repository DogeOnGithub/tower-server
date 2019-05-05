package cn.tjsanshao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"cn.tjsanshao.mapper"})
@SpringBootApplication
public class TowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TowerApplication.class, args);
	}

}
