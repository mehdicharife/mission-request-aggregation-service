package ma.ensias.a.gl.g1.mission_request_aggregation_service.mapper;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.FlattenedMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.MissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.Mission;

public class FlattenedMissionRequestMapper {
    
    public static Mission toMission(FlattenedMissionRequest flattenedMissionRequest) {
        Mission mission = new Mission();
        mission.setTitle(flattenedMissionRequest.getMissionTitle());
        mission.setDescription(flattenedMissionRequest.getMissionDescription());
        return mission;
    }

    public static MissionRequest toMissionRequest(FlattenedMissionRequest flattenedMissionRequest, Long missionId) {
        MissionRequest missionRequest = new MissionRequest();
        missionRequest.setMissionId(missionId);
        missionRequest.setProfessorId(flattenedMissionRequest.getProfessorId());
        missionRequest.setRequestDate(flattenedMissionRequest.getRequestDate());

        return missionRequest;
    }
}
