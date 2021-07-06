package football.tickets.app.service.mapper;

import football.tickets.app.dto.request.RivalryRequestDto;
import football.tickets.app.dto.response.RivalryResponseDto;
import football.tickets.app.model.Rivalry;
import org.springframework.stereotype.Component;

@Component
public class RivalryMapper implements RequestDtoMapper<RivalryRequestDto, Rivalry>,
        ResponseDtoMapper<RivalryResponseDto, Rivalry> {
    @Override
    public Rivalry mapToModel(RivalryRequestDto dto) {
        Rivalry rivalry = new Rivalry();
        rivalry.setTitle(dto.getRivalryTitle());
        rivalry.setDescription(dto.getRivalryDescription());
        return rivalry;
    }

    @Override
    public RivalryResponseDto mapToDto(Rivalry rivalry) {
        RivalryResponseDto responseDto = new RivalryResponseDto();
        responseDto.setRivalryId(rivalry.getId());
        responseDto.setRivalryTitle(rivalry.getTitle());
        responseDto.setRivalryDescription(rivalry.getDescription());
        return responseDto;
    }
}
