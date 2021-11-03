package com.poc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.poc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
List<User> findAllByOrderByDobAsc();
List<User> findAllByOrderByDojAsc();
List<User> findAllByOrderByDobAscDojAsc();
@Modifying
@Transactional
@Query("update User set deleted=true where user_id=:user_id")
int softDeleteUser(@Param(value = "user_id") int user_id);
}
