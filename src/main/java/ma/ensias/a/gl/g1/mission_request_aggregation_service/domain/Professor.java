package ma.ensias.a.gl.g1.mission_request_aggregation_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Professor {

    private Long id;

    private String fullName;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullName='" + getFullName() + "'" +
            "}";
    }
    
    
}
