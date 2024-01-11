package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.MissionRequest;

public class MissionRequestClientImpl implements MissionRequestClient {

    @Autowired
    private RestTemplate restTemplate;

    private String MISSION_SERVICE;

    public List<MissionRequest> getAllMissionRequests() {
        ResponseEntity<List<MissionRequest>> getMissionRequestsResponse = this.restTemplate.
            exchange(MISSION_SERVICE, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<MissionRequest>>(){}
        );

        return getMissionRequestsResponse.getBody();
    }



    public List<MissionRequest> getMissionRequestsByRequesterId(Long id) {
        ResponseEntity<List<MissionRequest>> getMissionRequestsResponse = this.restTemplate.
            exchange(MISSION_SERVICE + "?professorId=" + id, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<MissionRequest>>(){}
        );

        return getMissionRequestsResponse.getBody();
    }
    
}
