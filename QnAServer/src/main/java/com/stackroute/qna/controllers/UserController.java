package com.stackroute.qna.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.qna.model.User;
import com.stackroute.qna.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.stackroute.qna.exceptions.UserNotFoundException;
import com.stackroute.qna.exceptions.UserAlreadyExistsException;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
// @CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class UserController {

	HashMap<String, String> map = new HashMap<String, String>();

	@Autowired
	private UserService userService;

	// <--register method-->
	@PostMapping(path = "/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
		} catch (UserAlreadyExistsException e) {
			String exceptionMessage = e.getMessage();
			map.clear();
			map.put("success", "false");
			map.put("message", exceptionMessage);
			return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.CONFLICT);
		}
		map.clear();
		map.put("success", "true");
		map.put("message", "user registered successfully");
		return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.CREATED);
	}

	// <--login method-->
	@PostMapping(path = "/login")
	public ResponseEntity<?> login(@RequestBody User loginUser) throws ServletException, UserNotFoundException {

		String jwtToken = "";

		try {
			if (loginUser.getUserId() == null || loginUser.getPassword() == null) {
				throw new ServletException("Please fill in username and password");
			}

			String userId = loginUser.getUserId();
			String password = loginUser.getPassword();

			User user = userService.getUserById(userId);

			if (user == null) {
				throw new UserNotFoundException("User not found.");
			}

			String pwd = user.getPassword();

			if (!password.equals(pwd)) {
				throw new ServletException("Invalid login. Please check your name and password.");
			}

			jwtToken = Jwts.builder().setSubject(userId).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			map.clear();
			map.put("message", "User successfully logged in");
			map.put("token", jwtToken);

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			map.clear();
			map.put("token", null);
			map.put("message", exceptionMessage);
			return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.OK);
	}
}
