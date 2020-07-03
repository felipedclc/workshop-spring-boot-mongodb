package com.felipedclc.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipedclc.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // ?0(PRIMEIRO PARAMETRO DO METODO) = text / i IGNORA O CASE SENSITIVE
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); 
}
