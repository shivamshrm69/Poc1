package com.poc;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.poc.entity.User;
import com.poc.repositories.RegistrationRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RegistrationTest {
	@MockBean
	RegistrationRepository registrationRepo;

	@Test
	void saveUserTest() {
		User user = new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
				new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false);
		when(registrationRepo.save(user)).thenReturn(user);
	}

}
