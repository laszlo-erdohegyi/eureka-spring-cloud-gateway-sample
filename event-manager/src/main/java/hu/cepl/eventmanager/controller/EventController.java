package hu.cepl.eventmanager.controller;

import hu.cepl.eventmanager.model.Event;
import hu.cepl.eventmanager.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/event")
@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/case-id/{case-id}")
    public List<Event> getByCaseId(@PathVariable("case-id") Long caseId) {
        return eventService.findByCaseId(caseId);
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return eventService.findById(id);
    }

}
