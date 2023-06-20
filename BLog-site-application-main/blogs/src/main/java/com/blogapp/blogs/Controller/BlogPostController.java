package com.blogapp.blogs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.blogs.Entity.BlogPost;
import com.blogapp.blogs.Service.BlogPostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/home")
public class BlogPostController {
	
	@Autowired
	private BlogPostService postService;
	
	@PostMapping("")
	@ResponseBody
	public BlogPost addPost(@RequestBody BlogPost post)
	{
		return postService.saveorAddPost(post);
	}

	@GetMapping("/mypost/{email}")
	public List<BlogPost> getPostbyemail(@PathVariable String email)
	{
		return postService.getPostbyEmail(email);
	}
	@GetMapping("/otherblogs/{email}")
	public List<BlogPost> getOthersPostbyEmail(@PathVariable String email)
	{
		return postService.getOtherPosts(email);
	}
	
//	@PutMapping("/otherblogs")
//	public BlogPost updateComment(@RequestBody BlogPost post)
//	{
//		return postService.addComment(post);
//	}
	
	@DeleteMapping("/deleteBlogById/{pid}")
	public boolean deletePost(@PathVariable String pid)
	{
		return postService.deletePost(pid);
	}
}
