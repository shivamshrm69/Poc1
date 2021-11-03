package com.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.poc.entity.User;
import com.poc.repositories.FilterRepository;
import com.poc.services.FilterService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FilterTest {

	@MockBean
	FilterRepository filterRepo;

	@Autowired
	private FilterService filterService;
	@Test
	void searchFilter() {
		String input="shivam";
		when(filterRepo.filterData(input)).thenReturn(Stream
				.of(new User(1, "Shivam", "s", "Sharma", "Shivam@gmail.com", "male", new Date(1996, 8, 20),
						new Date(2021, 8, 20), "9876543212", "India", "Jharkhand", "Ranchi", "834001", false))
				.collect(Collectors.toList()));
		assertEquals(1, filterService.searchFilter("shivam").size());
	}
}
