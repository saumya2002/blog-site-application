package com.blogapp.blogs.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blogapp.blogs.Entity.BlogPost;

public interface BlogPostRepo extends MongoRepository<BlogPost, String> {

	@Query("{email:{$ne:?0}}")
	List<BlogPost> getOthersPost(String email);

	List<BlogPost> findAllByEmail(String email);

	Optional<BlogPost> findById(String blogId);

	void deleteById(String bid);
}
