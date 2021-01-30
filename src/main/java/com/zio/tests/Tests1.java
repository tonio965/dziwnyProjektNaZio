package com.zio.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class Tests1 {

//	@MockBean
//	private AppplicationService appService;
//	
//	
//	@Autowired
//	private UserService userService;
//	
//	@Test
//	void addUserToDb() {
//		int i = userService.returnAllUsers();
//		userService.createUser("test1", "test1", "test1", "test1");
//		int j = userService.returnAllUsers();
//		assertThat(j).isGreaterThan(i);
//	}
//	
//	@Test
//	void deletesUser() {
//		
//		userService.createUser("test2", "test2", "test2", "test2");
//		int i = userService.returnAllUsers();
//		userService.deleteUser("test2");
//		int j = userService.returnAllUsers();
//		assertThat(j).isLessThan(i);
//	}
}
