package com.felipedclc.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipedclc.workshopmongo.domain.Post;
import com.felipedclc.workshopmongo.domain.User;
import com.felipedclc.workshopmongo.dto.UserDTO;
import com.felipedclc.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") // CAMINHO DO END POINT
public class UserResource {

	@Autowired
	public UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @GetMapping
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

	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto); // CONVERTENDO O OBJ PARA USER 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); // COLOCA UM CABEÇALHO COM A URL DO NOVO RECURSO CRIADO(BOA PRATICA)
	} 
	
	@RequestMapping(value= "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) { // PATH VARIABLE ASSOCIA O ID(STRING) COM O ID(URL)
		service.delete(id);
		return ResponseEntity.noContent().build(); // RESPOSTA 204 
	}
	
	@RequestMapping(value= "/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto); // CONVERTENDO O OBJ PARA USER 
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build(); 

	}
	
	@RequestMapping(value= "/{id}/posts", method= RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) { // PATH VARIABLE ASSOCIA O ID(STRING) COM O ID(URL)
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}