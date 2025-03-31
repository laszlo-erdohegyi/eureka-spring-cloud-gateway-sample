package hu.cepl.eventmanager.service;

import hu.cepl.eventmanager.model.Event;

import java.util.List;

public interface EventService {

    List<Event> findByCaseId(Long caseId);

    Event findById(Long id);

}
