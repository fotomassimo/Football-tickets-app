package football.tickets.app.lib;

import football.tickets.app.dto.request.UserRequestDto;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

public class PasswordConstraintValidator
        implements ConstraintValidator<ValidPassword, UserRequestDto> {
    private static final String MESSAGE_DELIMITER = ",";

    @Override
    public boolean isValid(UserRequestDto requestDto, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new DigitCharacterRule(1),
                new UppercaseCharacterRule(1),
                new SpecialCharacterRule(1),
                new WhitespaceRule()));
        RuleResult result = validator.validate(new PasswordData(requestDto.getPassword()));
        if (result.isValid()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(
                String.join(MESSAGE_DELIMITER, validator.getMessages(result)))
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
