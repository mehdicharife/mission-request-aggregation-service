package ma.ensias.a.gl.g1.mission_request_aggregation_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.MissionClientImpl;

@Configuration
public class Config {
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl");
        return marshaller;
    }


    @Bean
    public MissionClientImpl missionClient(Jaxb2Marshaller marshaller) {
        MissionClientImpl missionClient = new MissionClientImpl();
        missionClient.setMarshaller(marshaller);
        missionClient.setUnmarshaller(marshaller);
        missionClient.setDefaultUri("http://localhost:8080/ws/");

        return missionClient;
    }


}
