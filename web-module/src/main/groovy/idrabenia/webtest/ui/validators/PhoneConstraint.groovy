package idrabenia.webtest.ui.validators

import java.lang.annotation.Target
import java.lang.annotation.Retention
import javax.validation.constraints.Past
import javax.validation.Constraint
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import javax.validation.Payload

/**
 *
 * @author Ilya Drabenia
 * @since 27.01.13
 */
@Target([ElementType.FIELD, ElementType.METHOD])
@Retention(RetentionPolicy.RUNTIME)

@Constraint(validatedBy = PhoneValidator.class)
@interface PhoneConstraint {

    String message() default "{javax.validation.constraints.PhoneConstraint.message}"

    Class<?>[] groups() default []

    Class<? extends Payload>[] payload() default []

}