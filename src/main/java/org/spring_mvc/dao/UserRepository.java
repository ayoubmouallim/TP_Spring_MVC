package org.spring_mvc.dao;

import org.spring_mvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String s);

}
