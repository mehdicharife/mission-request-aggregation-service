package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.MissionRequest;

public interface MissionRequestClient {

    List<MissionRequest> getAllMissionRequests();

    List<MissionRequest> getMissionRequestsByRequesterId(Long id);
    
}
