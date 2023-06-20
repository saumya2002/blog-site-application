package com.blogapp.blogs.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogapp.blogs.Entity.BlogUser;


public interface BlogUserRepository  extends MongoRepository<BlogUser,String> {
	
	public BlogUser findItemByEmail(String email);
	public BlogUser findItemByEmailAndPasscode(String email, String password);

 }
