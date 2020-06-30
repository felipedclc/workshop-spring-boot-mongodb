package com.felipedclc.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.workshopmongo.domain.User;
import com.felipedclc.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users") // CAMINHO DO END POINT
public class UserResource {

	@Autowired
	public UserService service;
	
	@RequestMapping(method=RequestMethod.GET) // ou @GetMapping 
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
