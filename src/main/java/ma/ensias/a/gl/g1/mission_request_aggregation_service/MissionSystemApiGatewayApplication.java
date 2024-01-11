package ma.ensias.a.gl.g1.mission_request_aggregation_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetAllMissionsResponse;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.GetMissionResponse;


@SpringBootApplication
public class MissionSystemApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionSystemApiGatewayApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(MissionClient missionClient) {
		return args -> {
			GetMissionResponse mission = missionClient.getMissionById((long) 2);
			GetAllMissionsResponse missions = missionClient.getAllMissions();

			for(int k = 0; k < missions.getMission().size(); k++) {
				System.out.println(missions.getMission().get(k).getDescription());
			}
			System.out.println(mission.getMission().getDescription());
		};
	}

}
