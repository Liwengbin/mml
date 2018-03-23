package com.mml;

import com.mml.domain.jpa.ExperimentDir;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MmlServerApplicationTests {

	@Test
	public void contextLoads() {
		ExperimentDir n = new ExperimentDir();
	}

}
