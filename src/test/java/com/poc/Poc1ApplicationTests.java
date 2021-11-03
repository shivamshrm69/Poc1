package com.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.poc.entity.User;
import com.poc.repositories.FilterRepository;
import com.poc.repositories.RegistrationRepository;
import com.poc.repositories.UserRepository;
import com.poc.services.FilterService;
import com.poc.services.RegistrationService;
import com.poc.services.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class Poc1ApplicationTests {

	@MockBean
	FilterRepository filterRepo;
	@MockBean
	RegistrationRepository registrationRepo;
	@MockBean
	UserRepository userRepo;

	@Autowired
	private FilterService filterService;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private UserService userService;

	@Test
	void getAllUsers() {
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false),
						new User(2, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
								new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllUser().size());
	}
	
	@Test
	void findAllByOrderByDobAsc() {
		when(userRepo.findAllByOrderByDobAsc()).thenReturn(Stream
				.of(new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false),
						new User(2, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
								new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getUsersOrderByDob().size());
	}
	
	@Test
	void findAllByOrderByDojAsc() {
		when(userRepo.findAllByOrderByDojAsc()).thenReturn(Stream
				.of(new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false),
						new User(2, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
								new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getUsersOrderByDoj().size());
	}
	
	@Test
	void findAllByOrderByDobAscDojAsc() {
		when(userRepo.findAllByOrderByDobAscDojAsc()).thenReturn(Stream
				.of(new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false),
						new User(2, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
								new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getUserOrderByDojAndDoj().size());
	}

	@Test
	void saveUserTest()
	{
		User user=new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
				new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false);
		when(registrationRepo.save(user)).thenReturn(user);
	}
	
	
	@Test
	void softDeleteUserTest()
	{
		userService.softDeleteUser(1);
		verify(userRepo,times(1)).softDeleteUser(1);
	}
	
	@Test
	void hardDeleteUserTest()
	{
		userService.hardDeleteUser(1);
		verify(userRepo,times(1)).deleteById(1);
	}
	
	@Test
	void searchFilter()
	{
		when(filterRepo.filterData("zzz")).thenReturn(Stream
				.of(new User(1, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false),
						new User(2, "shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
								new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(2, filterService.searchFilter("zzz").size());
	}
}
