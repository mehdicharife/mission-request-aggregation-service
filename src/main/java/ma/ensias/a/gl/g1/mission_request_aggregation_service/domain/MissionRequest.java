package ma.ensias.a.gl.g1.mission_request_aggregation_service.domain;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MissionRequest {

    private Long id;

    private Long missionId;

    private Long professorId;

    private String state;

    private Date requestDate;


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


    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }


    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", missionId='" + getMissionId() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
    
}
