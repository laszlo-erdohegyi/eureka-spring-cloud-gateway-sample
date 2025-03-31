package hu.cepl.personmanager.service;

import hu.cepl.personmanager.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findByEventId(Long eventId);

    Person findById(Long id);

}
