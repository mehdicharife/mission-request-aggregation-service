package ma.ensias.a.gl.g1.mission_request_aggregation_service.domain;

public class MissionRequest {

    private Long id;

    private Long missionId;

    private Long professorId;

    private String state;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }



    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
}
