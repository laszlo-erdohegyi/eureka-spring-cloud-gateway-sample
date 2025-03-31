package hu.cepl.personmanager.controller;

import hu.cepl.personmanager.model.Person;
import hu.cepl.personmanager.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/event-id/{event-id}")
    public List<Person> getByEventId(@PathVariable("event-id") Long eventId) {
        return personService.findByEventId(eventId);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.findById(id);
    }

}
