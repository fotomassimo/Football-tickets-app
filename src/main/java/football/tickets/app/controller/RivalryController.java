package football.tickets.app.controller;

import football.tickets.app.dto.request.RivalryRequestDto;
import football.tickets.app.dto.response.RivalryResponseDto;
import football.tickets.app.model.Rivalry;
import football.tickets.app.service.RivalryService;
import football.tickets.app.service.mapper.RivalryMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rivalries")
public class RivalryController {
    private final RivalryService rivalryService;
    private final RivalryMapper rivalryMapper;

    public RivalryController(RivalryService rivalryService, RivalryMapper rivalryMapper) {
        this.rivalryService = rivalryService;
        this.rivalryMapper = rivalryMapper;
    }

    @PostMapping
    public RivalryResponseDto add(@RequestBody @Valid RivalryRequestDto requestDto) {
        Rivalry rivalry = rivalryService.add(rivalryMapper.mapToModel(requestDto));
        return rivalryMapper.mapToDto(rivalry);
    }

    @GetMapping
    public List<RivalryResponseDto> getAll() {
        return rivalryService.getAll()
                .stream()
                .map(rivalryMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
