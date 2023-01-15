package com.example.hotels.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SecurityController {
	 
    @RequestMapping("/")
	public String l()
	{
	return "acceuil";
	}
    
	@RequestMapping("/acceuil")
	public String acceuil()
	{
	return "acceuil";
	}
	
	
	@GetMapping("/loginClient")
	public String loginC()
	{
	return "test";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException
	{
	request.logout();
	return "redirect:/login";
	}
	
@GetMapping("/accessDenied")
public String error()
{
return "accessDenied";
}


}
