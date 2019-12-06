package com.subu2code.expenses_tracker.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 *This is the Password Comparision Validate class.
 *Which is used to validate,
 *whether both the new password and confirm password was same or not.
 *
 * */

public class ComparePasswordsValidater implements ConstraintValidator<ComparePasswords, String>{

	public boolean isValid(String combinePassword, ConstraintValidatorContext context) {
       
		boolean isMatch = false;

		System.out.println(combinePassword);
		if(combinePassword!=null)
		{
			int mid = combinePassword.length()/2;
			String password = combinePassword.substring(0,mid);
			String confirmPassword = combinePassword.substring(mid, combinePassword.length());
			
			
			if(password.equals(confirmPassword))
			{
				isMatch = true;
				System.out.println(password+" "+confirmPassword+" was matched");
			}
			else
			{
				System.out.println(password+" "+confirmPassword+" not matched");
			}
		}
		return isMatch;
	}
	

}
