package ma.ensias.a.gl.g1.mission_request_aggregation_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl");
        return marshaller;
    }


    @Bean
    public MissionClient missionClient(Jaxb2Marshaller marshaller) {
        MissionClient missionClient = new MissionClient();
        missionClient.setMarshaller(marshaller);
        missionClient.setUnmarshaller(marshaller);
        missionClient.setDefaultUri("http://localhost:8080/ws/");

        return missionClient;
    }


}
