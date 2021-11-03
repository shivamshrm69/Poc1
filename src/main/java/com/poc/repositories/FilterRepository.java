package com.poc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poc.entity.User;

public interface FilterRepository extends JpaRepository<User, Integer>{
@Query("from User where pincode like %:value% or first_name like %:value% or middle_name like %:value% or last_name like %:value%")
List<User> filterData(@Param(value = "value") String value);
}
