package com.pcg.gitdemo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcg.gitdemo.repositories.UserRepository;
import com.pcg.gitdemo.models.User;

@Service
@Transactional
public class UserService {
	
	//Inject an instance of userRepository
	@Autowired
	private UserRepository repo;
	
	public Iterable<User> listAll(){
		return repo.findAll();
	}
	
	public void save(User emp) {
		repo.save(emp);
	}

	public User get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void count() {
		repo.count();
	}
}