package hu.cepl.casemanager.controller;

import hu.cepl.casemanager.client.LocationClient;
import hu.cepl.casemanager.model.Case;
import hu.cepl.casemanager.model.Location;
import hu.cepl.casemanager.service.CaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/case")
@RestController
public class CaseController {

    private final CaseService caseService;
    private final LocationClient locationClient;

    public CaseController(CaseService caseService, LocationClient locationClient) {
        this.caseService = caseService;
        this.locationClient = locationClient;
    }

    @GetMapping("/")
    public List<Case> getAll() {
        return caseService.findAll();
    }

    @GetMapping("/{id}")
    public Case getById(@PathVariable Long id) {
        return caseService.findById(id);
    }

    @GetMapping("/call-location-manager/{id}")
    public Location callLocationManager(@PathVariable Long id) {
        return locationClient.getById(id);
    }

}
