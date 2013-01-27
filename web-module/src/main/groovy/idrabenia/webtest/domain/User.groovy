package idrabenia.webtest.domain

import javax.validation.constraints.NotNull

import javax.validation.constraints.Size
import org.hibernate.validator.constraints.NotEmpty
import idrabenia.webtest.ui.converters.DateFormat

import idrabenia.webtest.ui.validators.DobConstraint
import idrabenia.webtest.ui.validators.PhoneConstraint

/**
 * 
 * @author Ilya Drabenia
 * @since 27.01.13
 */
class User {
    @NotNull
    @NotEmpty
    @Size(min = 3)
    String firstName

    @NotNull
    @NotEmpty
    @Size(min = 3)
    String lastName

    @NotNull
    @DateFormat
    @DobConstraint
    Date birthDate

    @NotNull
    @NotEmpty
    @PhoneConstraint
    String phoneNumber
}
