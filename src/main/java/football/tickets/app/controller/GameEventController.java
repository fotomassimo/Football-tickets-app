package football.tickets.app.controller;

import football.tickets.app.dto.request.GameEventRequestDto;
import football.tickets.app.dto.response.GameEventResponseDto;
import football.tickets.app.model.GameEvent;
import football.tickets.app.service.GameEventService;
import football.tickets.app.service.mapper.GameEventMapper;
import football.tickets.app.util.DateTimePatternUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-events")
public class GameEventController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final GameEventService gameEventService;
    private final GameEventMapper gameEventMapper;

    public GameEventController(GameEventService gameEventService,
                                  GameEventMapper gameEventMapper) {
        this.gameEventService = gameEventService;
        this.gameEventMapper = gameEventMapper;
    }

    @PostMapping
    public GameEventResponseDto add(@RequestBody @Valid GameEventRequestDto requestDto) {
        GameEvent gameEvent = gameEventMapper.mapToModel(requestDto);
        gameEventService.add(gameEvent);
        return gameEventMapper.mapToDto(gameEvent);
    }

    @GetMapping("/available")
    public List<GameEventResponseDto> getAll(@RequestParam Long rivalryId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                        LocalDate date) {
        return gameEventService.findAvailableEvents(rivalryId, date)
                .stream()
                .map(gameEventMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public GameEventResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid GameEventRequestDto requestDto) {
        GameEvent gameEvent = gameEventMapper.mapToModel(requestDto);
        gameEvent.setId(id);
        gameEventService.update(gameEvent);
        return gameEventMapper.mapToDto(gameEvent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameEventService.delete(id);
    }
}
