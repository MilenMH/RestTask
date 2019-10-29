package com.rest.task.demo;

import com.rest.task.demo.repositories.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DocumentRepository repository;

	@Test
	public void saveTest() {

	}

}
