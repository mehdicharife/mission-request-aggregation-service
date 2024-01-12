package ma.ensias.a.gl.g1.mission_request_aggregation_service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.Requester;

@Component
public class RequesterClientImpl implements RequesterClient{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${requester-service}")
    private String REQUESTER_SERVICE;

    
    public List<Requester> getAllRequesters() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String graphqlQuery = "{ \"query\": \"{ allProfessors { id, fullName } }\" }";
        HttpEntity<String> requestEntity = new HttpEntity<>(graphqlQuery, headers);
        
        ResponseEntity<GetAllProfessorsResponse> getRequestersResponse = this.restTemplate.
            exchange(REQUESTER_SERVICE, 
                HttpMethod.POST, 
                requestEntity, 
                new ParameterizedTypeReference<GetAllProfessorsResponse>(){}
        );

        return getRequestersResponse.getBody().getData().getAllProfessors();       
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class GetAllProfessorsResponse {

        public Data data;

        public Data getData() {
            return this.data;
        }        

        public void setData(Data data) {
            this.data = data;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Data {
            List<Requester> allProfessors;

            public List<Requester> getAllProfessors() {
                return this.allProfessors;
            }

            public void setAllProfessors(List<Requester> allProfessors) {
                this.allProfessors = allProfessors;
            }
        }
    }

    
    
}
