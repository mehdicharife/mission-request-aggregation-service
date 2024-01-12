package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.MissionRequest;


@Component
public class MissionRequestClientImpl implements MissionRequestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mission-request-service}")
    private String MISSION_REQUEST_SERVICE;

    public List<MissionRequest> getAllMissionRequests() {
        ResponseEntity<List<MissionRequest>> getMissionRequestsResponse = this.restTemplate.
            exchange(MISSION_REQUEST_SERVICE, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<MissionRequest>>(){}
        );

        return getMissionRequestsResponse.getBody();
    }



    public List<MissionRequest> getMissionRequestsByRequesterId(Long id) {
        ResponseEntity<List<MissionRequest>> getMissionRequestsResponse = this.restTemplate.
            exchange(MISSION_REQUEST_SERVICE + "?professorId=" + id, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<MissionRequest>>(){}
        );

        return getMissionRequestsResponse.getBody();
    }
    
}
