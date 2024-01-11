package ma.ensias.a.gl.g1.mission_request_aggregation_service;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionResponse;


public class MissionClient extends WebServiceGatewaySupport {

    public GetMissionResponse getMissionById(Long id) {
        GetMissionRequest getMissionRequest = new GetMissionRequest();

        getMissionRequest.setId(id);

        GetMissionResponse getMissionResponse = (GetMissionResponse) getWebServiceTemplate().
        marshalSendAndReceive("http://localhost:8080/ws",
            getMissionRequest,
            new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetMissionRequest")    
        );

        return getMissionResponse;
    }

    public GetAllMissionsResponse getAllMissions() {
        GetAllMissionsRequest getAllMissionsRequest = new GetAllMissionsRequest();

        GetAllMissionsResponse response = (GetAllMissionsResponse) getWebServiceTemplate().
            marshalSendAndReceive("http://localhost:8080/ws",
                getAllMissionsRequest,
                new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetMissionRequest")
            );
        return response;
    }

    
}
