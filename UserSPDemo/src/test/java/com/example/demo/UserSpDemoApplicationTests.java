package com.example.demo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @Test log use
 * @author yuxin
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserSpDemoApplication.class)

public class UserSpDemoApplicationTests {
	private Logger logger = Logger.getLogger(getClass());
	
	@Test
	public void testLogs() {
		logger.info("--------------output info--------------------");
		logger.debug("--------------output debug-----------------");
		logger.error("--------------output error-----------------");
	}

}
