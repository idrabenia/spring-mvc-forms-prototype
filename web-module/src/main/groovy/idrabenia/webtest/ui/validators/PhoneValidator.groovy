package idrabenia.webtest.ui.validators

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 * 
 * @author Ilya Drabenia
 * @since 27.01.13
 */
class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

    void initialize(PhoneConstraint constraintAnnotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value) {
            return false
        }

        def phoneRegexp = /^\+(?:[0-9] ?){6,14}[0-9]$/
        return value ==~ phoneRegexp
    }

}
