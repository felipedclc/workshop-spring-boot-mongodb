package com.felipedclc.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.workshopmongo.domain.User;
import com.felipedclc.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired // INSTANCIA ALTOMATICAMENTE OUTRAS CLASSES 
	private UserRepository repo; // CLASSE USER REPOSITORY
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
