package hu.cepl.locationmanager.controller;

import hu.cepl.locationmanager.model.Location;
import hu.cepl.locationmanager.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/location")
@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable Long id) {
        return locationService.findById(id);
    }

}
