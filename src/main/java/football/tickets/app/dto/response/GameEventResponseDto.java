package football.tickets.app.dto.response;

import lombok.Data;

@Data
public class GameEventResponseDto {
    private Long gameEventId;
    private Long rivalryId;
    private String rivalryTitle;
    private Long stadiumId;
    private String showTime;
}
