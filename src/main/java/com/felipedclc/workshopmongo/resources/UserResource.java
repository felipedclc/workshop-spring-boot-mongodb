package com.felipedclc.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.workshopmongo.domain.User;
import com.felipedclc.workshopmongo.dto.UserDTO;
import com.felipedclc.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") // CAMINHO DO END POINT
public class UserResource {

	@Autowired
	public UserService service;

	@RequestMapping(method= RequestMethod.GET) // ou @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());// CONVERTENDO A
																									// LISTA DE USER
																									// PARA DTO
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { // PATH VARIABLE ASSOCIA O ID(STRING) COM O ID(URL)
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	} 
}
