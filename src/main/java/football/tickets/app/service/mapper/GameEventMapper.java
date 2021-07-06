package football.tickets.app.service.mapper;

import football.tickets.app.dto.request.GameEventRequestDto;
import football.tickets.app.dto.response.GameEventResponseDto;
import football.tickets.app.model.GameEvent;
import football.tickets.app.service.RivalryService;
import football.tickets.app.service.StadiumService;
import football.tickets.app.util.DateTimePatternUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class GameEventMapper implements RequestDtoMapper<GameEventRequestDto, GameEvent>,
        ResponseDtoMapper<GameEventResponseDto, GameEvent> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StadiumService stadiumService;
    private final RivalryService rivalryService;

    public GameEventMapper(StadiumService stadiumService, RivalryService rivalryService) {
        this.stadiumService = stadiumService;
        this.rivalryService = rivalryService;
    }

    @Override
    public GameEvent mapToModel(GameEventRequestDto dto) {
        GameEvent gameEvent = new GameEvent();
        gameEvent.setRivalry(rivalryService.get(dto.getRivalryId()));
        gameEvent.setStadium(stadiumService.get(dto.getStadiumId()));
        gameEvent.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return gameEvent;
    }

    @Override
    public GameEventResponseDto mapToDto(GameEvent gameEvent) {
        GameEventResponseDto responseDto = new GameEventResponseDto();
        responseDto.setGameEventId(gameEvent.getId());
        responseDto.setStadiumId(gameEvent.getStadium().getId());
        responseDto.setRivalryId(gameEvent.getRivalry().getId());
        responseDto.setRivalryTitle(gameEvent.getRivalry().getTitle());
        responseDto.setShowTime(gameEvent.getShowTime().format(formatter));
        return responseDto;
    }
}
