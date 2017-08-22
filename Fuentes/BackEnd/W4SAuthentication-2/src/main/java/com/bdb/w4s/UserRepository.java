package com.bdb.w4s;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import authentication.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long> {

	
	List<User> findByEmail(String email);
}
