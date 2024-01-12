package ma.ensias.a.gl.g1.mission_request_aggregation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.MissionClient;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.MissionRequestClient;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.client.RequesterClient;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.FlattenedMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.MissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.Professor;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.wsdl.Mission;


@Service
public class FlattenedMissionRequestService {

    private MissionClient missionClient;

    private MissionRequestClient missionRequestClient;

    private RequesterClient requesterClient;


    public FlattenedMissionRequestService(MissionClient missionClient, MissionRequestClient missionRequestClient, RequesterClient requesterClient) {
        this.missionClient = missionClient;
        this.missionRequestClient = missionRequestClient;
        this.requesterClient = requesterClient;
    }
    
    public List<FlattenedMissionRequest> getAllFlattenedMissionRequests() {
        
        List<MissionRequest> missionRequests = missionRequestClient.getAllMissionRequests();
        List<Mission> missions = missionClient.getAllMissions();
        List<Professor> requesters = requesterClient.getAllRequesters();

        return getFlattenedMissionRequestsFrom(missionRequests, missions, requesters);
    }


    public List<FlattenedMissionRequest> getFlattenedMissionRequestsByRequesterId(Long id) {
        List<MissionRequest> missionRequests = this.missionRequestClient.getMissionRequestsByRequesterId(id);
        System.out.println(missionRequests);
        List<Mission> missions = missionClient.getAllMissions();
        System.out.println(missionRequests);
        System.out.println(missions.size());
        return getFlattenedMissionRequestsFrom(missionRequests, missions);
    }


    private List<FlattenedMissionRequest> getFlattenedMissionRequestsFrom(List<MissionRequest> missionRequests, List<Mission> missions, List<Professor> requesters) {
        List<FlattenedMissionRequest> flattenedMissionRequests = new ArrayList<>();

        for(MissionRequest missionRequest: missionRequests) {
            Mission mission = getMissionByIdFromList(missions, missionRequest.getMissionId());
            Professor requester = getRequesterByIdFromList(requesters, missionRequest.getProfessorId());
            FlattenedMissionRequest flattenedMissionRequest = aggregate(missionRequest, mission, requester);
            flattenedMissionRequests.add(flattenedMissionRequest);
        }

        return flattenedMissionRequests;

    }



    private List<FlattenedMissionRequest> getFlattenedMissionRequestsFrom(List<MissionRequest> missionRequests, List<Mission> missions) {
        List<FlattenedMissionRequest> flattenedMissionRequests = new ArrayList<>();

        for(MissionRequest missionRequest: missionRequests) {
            Mission mission = getMissionByIdFromList(missions, missionRequest.getMissionId());
            FlattenedMissionRequest flattenedMissionRequest = aggregate(missionRequest, mission);
            flattenedMissionRequests.add(flattenedMissionRequest);
        }

        return flattenedMissionRequests;

    }



    private FlattenedMissionRequest aggregate(MissionRequest missionRequest, Mission mission, Professor professor) {
        FlattenedMissionRequest flattenedMissionRequest = aggregate(missionRequest, mission);

        flattenedMissionRequest.setProfessorId(professor.getId());
        flattenedMissionRequest.setProfessorFullName(professor.getFullName());

        return flattenedMissionRequest;
    }


    private FlattenedMissionRequest aggregate(MissionRequest missionRequest, Mission mission) {
        FlattenedMissionRequest flattenedMissionRequest = new FlattenedMissionRequest();

        flattenedMissionRequest.setId(missionRequest.getId());
        flattenedMissionRequest.setRequestDate(null);
        flattenedMissionRequest.setRequestDate(null);
        flattenedMissionRequest.setState(missionRequest.getState());

        flattenedMissionRequest.setMissionId(mission.getId());
        flattenedMissionRequest.setMissionTitle(mission.getTitle());
        flattenedMissionRequest.setMissionDescription(mission.getDescription());
        flattenedMissionRequest.setMissionStartDate(null);
        flattenedMissionRequest.setMissionEndDate(null);

        return flattenedMissionRequest;
    }

    private Mission getMissionByIdFromList(List<Mission> missions, Long id) {
        for(Mission mission : missions) {
            if(mission.getId() == id) {
                return mission;
            }
        }
        return null;
    }


    private Professor getRequesterByIdFromList(List<Professor> requesters, Long id) {
        for(Professor requester : requesters) {
            if(requester.getId() == id) {
                return requester;
            }
        }
        return null;
    }



    
}
