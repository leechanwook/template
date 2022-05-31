package com.cu.template;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TemplateApplicationTests {

	@Autowired
	RuntimeTest runttimeTest;

	@Test
	void contextLoads() {
	}

}
