package football.tickets.app.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_REGEX_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\."
            + "[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(EMAIL_REGEX_PATTERN);
    }
}
