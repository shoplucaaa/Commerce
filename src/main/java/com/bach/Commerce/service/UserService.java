package com.bach.Commerce.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.bach.Commerce.entity.AuthenticationProvider;
import com.bach.Commerce.entity.User;
import com.bach.Commerce.model.UserDTO;

import javax.mail.MessagingException;

public interface UserService {
	
	public UserDTO getUserById(int id);
	
	public List<UserDTO> getAllUser();

	public User addUser(UserDTO userDTO);
	
	public UserDTO getUserByMail(String mail);

	public void registerNewUserAfterOAuthLoginSuccess(String email, String name, AuthenticationProvider facebook);

	public User getCurrentlyLoggedInUser(Authentication authentication);
	
	public User editUser(UserDTO userDTO);
	
	public void deleteUser(int id);

	void generateOneTimePassword(UserDTO userDTO) throws MessagingException, UnsupportedEncodingException;
}
