package ma.ensias.a.gl.g1.mission_request_aggregation_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ensias.a.gl.g1.mission_request_aggregation_service.domain.FlattenedMissionRequest;
import ma.ensias.a.gl.g1.mission_request_aggregation_service.service.FlattenedMissionRequestService;

@RestController
@RequestMapping("/flattened-mission-requests")
public class FlattenedMissionRequestController {
    
    @Autowired
    private FlattenedMissionRequestService flattenedMissionRequestService;

    @GetMapping
    public List<FlattenedMissionRequest> getAllFlattenedMissionRequests(@RequestParam(value = "professorId", required = false) Optional<Long> profId) {
        if(profId.isPresent()) {
            return flattenedMissionRequestService.getFlattenedMissionRequestsByRequesterId(profId.get());
        }
        return this.flattenedMissionRequestService.getAllFlattenedMissionRequests();
    }

}
