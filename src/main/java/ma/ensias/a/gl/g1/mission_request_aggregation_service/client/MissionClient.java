package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.Mission;

public interface MissionClient {

    List<Mission> getAllMissions();

    Mission createMission(Mission mission);
    
}
