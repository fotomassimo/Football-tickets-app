package football.tickets.app.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StadiumRequestDto {
    @Min(500)
    private int capacity;
    @Size(max = 200)
    private String description;
}
