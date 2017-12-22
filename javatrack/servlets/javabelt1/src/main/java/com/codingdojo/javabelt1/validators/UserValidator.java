package com.codingdojo.javabelt1.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.javabelt1.models.User;
import com.codingdojo.javabelt1.repositories.UserRepository;


@Component
public class UserValidator implements Validator {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
        User user = (User) object;
        User checkUser = userRepo.findByEmail(user.getEmail());
        if (checkUser != null) {
        	errors.rejectValue("email", "InUse" );
        }
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }     
	}

}
