package com.blogapp.blogs.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.blogs.Entity.BlogPost;
import com.blogapp.blogs.Entity.Comment;
import com.blogapp.blogs.Repository.BlogPostRepo;



@Service
public class BlogPostService {
	
	@Autowired
	private BlogPostRepo blogPostRepo;
	
	public BlogPost saveorAddPost(BlogPost post)
	{
		return blogPostRepo.save(post);
	}
	
	public boolean deletePost(String bid) {
		Optional<BlogPost> bp = blogPostRepo.findById(bid);
		if(bp == null) return false;
		
		blogPostRepo.deleteById(bid);
		return false;
	}
	
	public List<BlogPost> getOtherPosts(String email){
		return blogPostRepo.getOthersPost(email);
	}
	
	public List<BlogPost> getPostbyEmail(String email)
	{
		return blogPostRepo.findAllByEmail(email);	
	}
	
//	public Optional<BlogPost> addComment(String c) {
//		String blogId = c.getBlogPost().getBlogId();
//		Optional<BlogPost> blog = blogPostRepo.findById(blogId);
//		if(blog == null) return blog;
//		else
//		return blog;
//		
//	}

}
