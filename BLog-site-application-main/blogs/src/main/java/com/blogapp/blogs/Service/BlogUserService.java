package com.blogapp.blogs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.blogapp.blogs.Entity.BlogUser;
import com.blogapp.blogs.Repository.BlogUserRepository;

@Service
public class BlogUserService {
	
	@Autowired
	private BlogUserRepository userRepo;
	
	public BlogUser addUser(BlogUser user)
	{
		return userRepo.save(user);
	}
	public BlogUser fetchUserByEmail(String email)
	{
		return userRepo.findItemByEmail(email);
	}
	
	public BlogUser fetchUserByEmailIdAndPassword(String email,String password)
	{
		return userRepo.findItemByEmailAndPasscode(email, password);
	}

}
