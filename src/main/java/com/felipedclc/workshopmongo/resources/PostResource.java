package com.felipedclc.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipedclc.workshopmongo.domain.Post;
import com.felipedclc.workshopmongo.resources.util.URL;
import com.felipedclc.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts") // CAMINHO DO END POINT
public class PostResource {

	@Autowired
	public PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) { // PATH VARIABLE ASSOCIA O ID(STRING) COM O ID(URL) (/)
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) { // PARAMETRO DE
																													// BUSCA (?)
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}