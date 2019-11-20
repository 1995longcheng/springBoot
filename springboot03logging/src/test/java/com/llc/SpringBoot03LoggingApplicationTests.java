package com.llc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {
	private static Logger log = LoggerFactory.getLogger(SpringBoot03LoggingApplicationTests.class);

	/*
	日志级别；
	由低到高 trace<debug<info<warn<error
	可以调整输出的日志级别；日志就只会在这个级别更高级别生效
	 */
	@Test
	public void contextLoads() {
		log.trace("这是跟踪级别");
		log.debug("这是debug级别");
		//springboot 默认给我们使用的是info级别的，没有指定级别的就用springboot默认规定的级别；root级别
		log.info("这是info信息级别");
		log.warn("这是warn级别");
		log.error("这是error级别");
	}

}
