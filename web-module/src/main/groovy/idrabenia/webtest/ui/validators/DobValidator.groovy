package idrabenia.webtest.ui.validators

import javax.validation.ConstraintValidator

import javax.validation.ConstraintValidatorContext

/**
 * 
 * @author Ilya Drabenia
 * @since 27.01.13
 */
class DobValidator implements ConstraintValidator<DobConstraint, Date> {

    void initialize(DobConstraint constraintAnnotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    boolean isValid(Date value, ConstraintValidatorContext context) {
        if (!value) return true

        int year = value.year + 1900
        int curYear = new Date().year + 1900

        return (curYear - year < 120)
    }

}
