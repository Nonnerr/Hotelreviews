package com.example.myproject.repo;

import com.example.myproject.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ItemReposetory extends CrudRepository <Post, Long> {
}
