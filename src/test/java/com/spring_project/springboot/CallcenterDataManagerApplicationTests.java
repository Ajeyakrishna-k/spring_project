package com.spring_project.springboot;

import com.spring_project.springboot.service.CallDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CallcenterDataManagerApplicationTests {

	@Autowired
	CallDataService callDataService;
	@Test
	void contextLoads(){
	}
}
