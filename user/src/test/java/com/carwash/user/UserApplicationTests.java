package com.carwash.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.carwash.user.models.User;
import com.carwash.user.repositories.UserRepository;
import com.carwash.user.services.UserService;

@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void getUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User("Denis", "Ritchie","denis@gmail.com", "USA","12345","lamborghini")).collect(Collectors.toList()));
		assertEquals(1, service.getUsers().size());
	}
	
	@Test
	public void saveUserTest() {
		User user = new User("Ak", "kk", "Ak@gmail.com", "Pune","123456","ford gt");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
//	@Test
//	public void deleteUserTest() {
//		String emailId = "Ak@gmail.com";
//		service.deleteUser(emailId);
//		verify(userRepository, times(1)).delete(user);
//	}

}
