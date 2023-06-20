package com.blogapp.blogs.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogapp.blogs.Entity.BlogUser;
import com.blogapp.blogs.Service.BlogUserService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class BlogUserController {

	@Autowired
	private BlogUserService userService;
	
	@PostMapping("/register")
	@ResponseBody
	public BlogUser adduser(@Valid @RequestBody BlogUser user) throws Exception
	{   String tempemail = user.getEmail();
	 if( tempemail != null && !"".equals(tempemail) )
	 {
		 BlogUser userobj = userService.fetchUserByEmail(tempemail);
		 if(userobj !=null)
		 {
			 throw new Exception("user with " + tempemail + "already Exists");
		 }
	 }
	 return userService.addUser(user);
	}
	
	@PostMapping("/login")
	   @ResponseBody
    public BlogUser loginUser(@RequestBody BlogUser user)  throws Exception
    {
 	   String tempemail = user.getEmail();
 	   String tempass = user.getPasscode();
 	   BlogUser userobj=null;
 	   if(tempemail != null && tempass!=null)
 	   {
 		   userobj = userService.fetchUserByEmailIdAndPassword(tempemail, tempass);
 		   
 	   }
 		   if(userobj == null)
 		   {
 			   throw new Exception("User doesn't exist");
 		   }
 	   
 	   return userobj;
 	   
    }
	
}
