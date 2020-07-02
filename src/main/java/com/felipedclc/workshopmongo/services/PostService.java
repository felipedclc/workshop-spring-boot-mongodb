package com.felipedclc.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedclc.workshopmongo.domain.Post;
import com.felipedclc.workshopmongo.repository.PostRepository;
import com.felipedclc.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
