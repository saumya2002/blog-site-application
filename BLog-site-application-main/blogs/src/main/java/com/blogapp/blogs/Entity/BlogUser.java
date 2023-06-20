package com.blogapp.blogs.Entity;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class BlogUser {
	
	@Id
	private String user_id;
	
	@NotBlank(message = "Name can't be left Blank")
	private String name;
	
	@Indexed(name="email_index",unique=true)
	@Email(message="Enter a valid email")
	private String email;
	
	@NotNull 
	@Size(min=7)
	private String passcode;
	
	@NotNull 
	@Size(min=7)
	private String repeat_passcode;

	public BlogUser(@NotBlank(message = "Name can't be left Blank") String name,
			@Email(message = "Enter a valid email") String email, @NotNull @Size(min = 7) String passcode,
			@NotNull @Size(min = 7) String repeat_passcode) {
		super();
		this.name = name;
		this.email = email;
		this.passcode = passcode;
		this.repeat_passcode = repeat_passcode;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getRepeat_passcode() {
		return repeat_passcode;
	}

	public void setRepeat_passcode(String repeat_passcode) {
		this.repeat_passcode = repeat_passcode;
	}

	@Override
	public String toString() {
		return "BlogUser [user_id=" + user_id + ", name=" + name + ", email=" + email + ", passcode=" + passcode
				+ ", repeat_passcode=" + repeat_passcode + "]";
	}
	

}
