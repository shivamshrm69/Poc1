package com.poc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.poc.entity.User;

public interface RegistrationRepository extends CrudRepository<User, Integer>{

}
