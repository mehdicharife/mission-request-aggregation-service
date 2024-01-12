package ma.ensias.a.gl.g1.mission_request_aggregation_service.mapper;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.FlattenedMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.dto.CreateMissionRequestDto;

public class CreateMissionRequestDtoMapper {

    public static FlattenedMissionRequest fromDto(CreateMissionRequestDto createMissionRequestDto) {
        FlattenedMissionRequest flattenedMissionRequest = new FlattenedMissionRequest();
        flattenedMissionRequest.setRequestDate(createMissionRequestDto.getRequestDate());

        flattenedMissionRequest.setMissionTitle(createMissionRequestDto.getMissionTitle());
        flattenedMissionRequest.setMissionDescription(createMissionRequestDto.getMissionDescription());
        flattenedMissionRequest.setMissionStartDate(createMissionRequestDto.getMissionStartDate());
        flattenedMissionRequest.setMissionEndDate(createMissionRequestDto.getMissionEndDate());

        flattenedMissionRequest.setProfessorId(createMissionRequestDto.getProfessorId());

        return flattenedMissionRequest;

    }
    
}
