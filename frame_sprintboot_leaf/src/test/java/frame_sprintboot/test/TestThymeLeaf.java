package frame_sprintboot.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import boot.entry;
import trytest.thymeleaf.bean.Car;
import trytest.thymeleaf.service.CarService;
import trytest.thymeleaf.service.impl.CarServiceImpl;

@RunWith(SpringRunner.class) 
@SpringBootTest(classes=entry.class)
public class TestThymeLeaf {
	@Autowired
	CarService userService ; 
	
	@Test
	public void test1() {
		Car u = new Car();
		u.setName("pooo---pp");
		u.setHp(10);
		userService.add(u);
		System.out.println("--------run here");
		
	}
}
