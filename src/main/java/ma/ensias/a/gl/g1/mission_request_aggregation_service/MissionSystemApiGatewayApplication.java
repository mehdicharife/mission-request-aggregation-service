package ma.ensias.a.gl.g1.mission_request_aggregation_service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.MissionClientImpl;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.RequesterClient;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.Professor;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.Mission;


@SpringBootApplication
public class MissionSystemApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionSystemApiGatewayApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner(MissionClientImpl missionClient) {
		return args -> {
			GetMissionResponse mission = missionClient.getMissionById((long) 2);
			List<Mission> missions = missionClient.getAllMissions();

			for(int k = 0; k < missions.size(); k++) {
				System.out.println(missions.get(k).getDescription());
			}
			System.out.println(mission.getMission().getDescription());
		};
	}

	/*
	@Bean
	public CommandLineRunner runner(RequesterClient requesterClient) {
		return args -> {
			List<Requester> requesters = requesterClient.getAllRequesters();
			System.out.println(requesters);
		};
	}*/

}
