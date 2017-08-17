package com.bdb.w4s.Data;

import com.bdb.w4s.Model.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByemail(String email);
}