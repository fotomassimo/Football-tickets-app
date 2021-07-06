package football.tickets.app.dto.request;

import football.tickets.app.lib.FieldsValueMatch;
import football.tickets.app.lib.ValidEmail;
import lombok.Data;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
@Data
public class UserRequestDto {
    @ValidEmail
    private String email;
    private String password;
    private String repeatPassword;
}
