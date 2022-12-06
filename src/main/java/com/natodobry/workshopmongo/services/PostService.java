package com.natodobry.workshopmongo.services;

import com.natodobry.workshopmongo.domain.Post;
import com.natodobry.workshopmongo.repository.PostRepository;
import com.natodobry.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }
    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }
    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
