package org.spring_mvc.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.spring_mvc.dao.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	
	@GetMapping("/notAuthorized")
	public String error()
	{
		return "notAuthorized";
	}
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException
	{
		request.logout();
		
		return "redirect:/login";
	}
	
	
	@GetMapping("/profil")
	public String profil()
	{		
		return "profil";
	}
}
