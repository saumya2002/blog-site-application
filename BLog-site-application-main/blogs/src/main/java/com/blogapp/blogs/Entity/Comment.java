package com.blogapp.blogs.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class Comment {
	
	@Id
	private String commentId;
	
	@DBRef
	private BlogUser user;

	@DBRef
	private BlogPost blogPost;
	
	private String content;

	public Comment(BlogUser user, String content) {
		super();
		this.user = user;
		this.content = content;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public BlogUser getUser() {
		return user;
	}

	public void setUser(BlogUser user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public BlogPost getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}
	
	
}
