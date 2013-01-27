package idrabenia.webtest.ui.validators

import java.lang.annotation.Target
import java.lang.annotation.Retention
import javax.validation.Constraint
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.ElementType
import javax.validation.Payload
import javax.validation.constraints.Past

/**
 *
 * @author Ilya Drabenia
 * @since 27.01.13
 */
@Target([ElementType.FIELD, ElementType.METHOD])
@Retention(RetentionPolicy.RUNTIME)

@Past
@Constraint(validatedBy = DobValidator.class)
@interface DobConstraint {
    String message() default "{javax.validation.constraints.DobConstraint.message}"

    Class<?>[] groups() default []

    Class<? extends Payload>[] payload() default []
}
