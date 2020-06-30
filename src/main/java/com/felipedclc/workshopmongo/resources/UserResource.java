package com.felipedclc.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users") // CAMINHO DO END POINT
public class UserResource {

	@RequestMapping(method=RequestMethod.GET) // ou @GetMapping 
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Velasquez", "mariav@gmail.com");
		User juan = new User("2", "Juan Pablo", "jp@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, juan));
		return ResponseEntity.ok().body(list);
	}
}
