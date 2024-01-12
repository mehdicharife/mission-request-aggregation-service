package ma.ensias.a.gl.g1.mission_request_aggregation_service.dto;

import java.sql.Date;


public class CreateMissionRequestDto {
    
    private Date requestDate;


    private String missionTitle;


    private String missionDescription;


    private Date missionStartDate;


    private Date missionEndDate;
    

    private Long professorId;



    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getMissionTitle() {
        return this.missionTitle;
    }

    public void setMissionTitle(String missionTitle) {
        this.missionTitle = missionTitle;
    }

    public String getMissionDescription() {
        return this.missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public Date getMissionStartDate() {
        return this.missionStartDate;
    }

    public void setMissionStartDate(Date missionStartDate) {
        this.missionStartDate = missionStartDate;
    }

    public Date getMissionEndDate() {
        return this.missionEndDate;
    }

    public void setMissionEndDate(Date missionEndDate) {
        this.missionEndDate = missionEndDate;
    }

    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }


    @Override
    public String toString() {
        return "{" +
            " requestDate='" + getRequestDate() + "'" +
            ", missionTitle='" + getMissionTitle() + "'" +
            ", missionDescription='" + getMissionDescription() + "'" +
            ", missionStartDate='" + getMissionStartDate() + "'" +
            ", missionEndDate='" + getMissionEndDate() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            "}";
    }

}
