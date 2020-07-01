package com.felipedclc.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.workshopmongo.domain.User;
import com.felipedclc.workshopmongo.repository.UserRepository;
import com.felipedclc.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // INSTANCIA ALTOMATICAMENTE OUTRAS CLASSES 
	private UserRepository repo; // CLASSE USER REPOSITORY
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
