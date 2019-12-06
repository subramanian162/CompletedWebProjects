package com.subu2code.expenses_tracker.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/*
 *This is the Password Comparision Validated annotation
 *
 * */

@Constraint(validatedBy = ComparePasswordsValidater.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComparePasswords {
	
	String message() default "Your paswords are not matching!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
