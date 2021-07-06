package football.tickets.app.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class GameEventRequestDto {
    @NotNull(message = "Please provide a rivalry id")
    @Positive(message = "Number should be greater than 0")
    private Long rivalryId;
    @NotNull(message = "Please provide a stadium id")
    @Positive(message = "Number should be greater than 0")
    private Long stadiumId;
    @NotNull
    @Size(min = 14)
    private String showTime;
}
