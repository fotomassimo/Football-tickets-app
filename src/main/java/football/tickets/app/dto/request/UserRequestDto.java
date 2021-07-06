package football.tickets.app.dto.request;

import football.tickets.app.lib.FieldsValueMatch;
import football.tickets.app.lib.ValidEmail;
import football.tickets.app.lib.ValidPassword;
import lombok.Data;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
@Data
@ValidPassword
public class UserRequestDto {
    @ValidEmail
    private String email;
    private String password;
    private String repeatPassword;
}
