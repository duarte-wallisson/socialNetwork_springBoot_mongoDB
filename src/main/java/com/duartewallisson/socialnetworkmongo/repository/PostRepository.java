package com.duartewallisson.socialnetworkmongo.repository;

import com.duartewallisson.socialnetworkmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
