package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.CreateMissionRequest;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.Mission;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.CreateMissionResponse;

@Component
public class MissionClientImpl extends WebServiceGatewaySupport implements MissionClient {

    @Value("${mission-service}")
    private String MISSION_SERVICE;

    public GetMissionResponse getMissionById(Long id) {
        GetMissionRequest getMissionRequest = new GetMissionRequest();

        getMissionRequest.setId(id);

        GetMissionResponse getMissionResponse = (GetMissionResponse) getWebServiceTemplate().
        marshalSendAndReceive(MISSION_SERVICE,
            getMissionRequest,
            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetMissionRequest")    
        );

        return getMissionResponse;
    }

    public List<Mission> getAllMissions() {
        GetAllMissionsRequest getAllMissionsRequest = new GetAllMissionsRequest();

        GetAllMissionsResponse response = (GetAllMissionsResponse) getWebServiceTemplate().
            marshalSendAndReceive("http://localhost:8080/ws",
                getAllMissionsRequest,
                new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetMissionRequest")
        );

        return response.getMission();
    }


    public Mission createMission(Mission mission) {
        CreateMissionRequest createMissionRequest = new CreateMissionRequest();
        createMissionRequest.setTitle(mission.getTitle());
        createMissionRequest.setDescription(mission.getDescription());

        CreateMissionResponse createMissionResponse = (CreateMissionResponse) getWebServiceTemplate().
            marshalSendAndReceive("http://localhost:8080/ws", 
            createMissionRequest,
            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/CreateMissionRequest")
        );

        Mission createdMission = createMissionResponse.getMission();
        mission.setId(createdMission.getId());
        return mission;
    }

    
}
