package com.wilson.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilson.dev.domain.Post;
import com.wilson.dev.repository.PostRepository;
import com.wilson.dev.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> userOpt = postRepository.findById(id);
		if(!userOpt.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return userOpt.get();
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContaining(text);
	}
	
}