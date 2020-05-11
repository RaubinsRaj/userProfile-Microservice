package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.UserProfileRepository;
import com.cg.entity.UserProfile;


@RestController
public class UserProfileController {

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	
	
	@PostMapping(path = "/userprofile/signupIntoPersonalDetails")
	public UserProfile userSignUp(@RequestBody UserProfile user) {
		return userProfileRepository.save(user); 
	}
	
	@PutMapping(path="/userprofile/updatePersonalDetails/{userId}")
	public UserProfile updateProfileDetails(@RequestBody UserProfile user, @PathVariable String userId) 
	{

		
		if (userProfileRepository.findById(userId) != null) {
			UserProfile existingUser=userProfileRepository.findById(userId).get();
			existingUser.setUserId(user.getUserId());
			existingUser.setUserName(user.getUserName());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setGender(user.getGender());
			existingUser.setDob(user.getDob());
			existingUser.setMobileNo(user.getMobileNo());
			existingUser.setAddress(user.getAddress());
			final UserProfile updatedUser = userProfileRepository.save(existingUser);
			return updatedUser;
			
		}
	
		return null;
	}
	

	
}
