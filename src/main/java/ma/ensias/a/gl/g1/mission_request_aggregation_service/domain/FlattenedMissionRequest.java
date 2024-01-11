package ma.ensias.a.gl.g1.mission_request_aggregation_service.domain;

import java.util.Date;

public class FlattenedMissionRequest {

    private Long id;

    private Long requesterId;

    private Date requestDate;

    private String state;

    private String requesterFullName;

    private Long missionId;

    private String missionTitle;

    private String missionDescription;

    private Date missionStartDate;

    private Date missionEndDate;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Long getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterFullName() {
        return this.requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
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



    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
}
