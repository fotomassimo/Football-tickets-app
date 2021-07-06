package football.tickets.app.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class RivalryRequestDto {
    @NotNull(message = "Please provide a title")
    @NotEmpty(message = "Please provide a title")
    @Size(min = 1, max = 255)
    private String rivalryTitle;
    @Size(max = 200)
    private String rivalryDescription;
}
