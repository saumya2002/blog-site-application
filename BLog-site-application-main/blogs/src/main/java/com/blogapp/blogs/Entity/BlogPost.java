package com.blogapp.blogs.Entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class BlogPost {
	
	@Id
	private String blogId;
	
	private String email;
	private String title;
	private String content;

	public BlogPost(String email, String title, String content
) {
		super();
		this.email = email;
		this.title = title;
		this.content = content;
	}

	public String getBlogId() {
		return blogId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public List<String> getComments() {
//		return comments;
//	}
//
//	public void setComments(String comment) {
//		comments.add(comment);
//		return;
//	}
	
	
}
