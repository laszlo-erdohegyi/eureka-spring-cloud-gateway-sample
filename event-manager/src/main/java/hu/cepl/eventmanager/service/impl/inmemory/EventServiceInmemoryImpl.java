package hu.cepl.eventmanager.service.impl.inmemory;

import hu.cepl.eventmanager.client.LocationClient;
import hu.cepl.eventmanager.exception.EventServiceException;
import hu.cepl.eventmanager.model.Event;
import hu.cepl.eventmanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class EventServiceInmemoryImpl implements EventService {

    private final LocationClient locationClient;

    private final Event event1 = Event.builder().id(1L).caseId(1L).description("Description of event 1")
            .date(LocalDateTime.of(2024, 1, 2, 3, 4)).locationId(1L).build();
    private final Event event2 = Event.builder().id(2L).caseId(1L).description("Description of event 2")
            .date(LocalDateTime.of(2024, 2, 3, 4, 5)).locationId(2L).build();
    private final Event event3 = Event.builder().id(3L).caseId(1L).description("Description of event 3")
            .date(LocalDateTime.of(2024, 3, 4, 5, 6)).locationId(3L).build();
    private final Event event4 = Event.builder().id(4L).caseId(1L).description("Description of event 4")
            .date(LocalDateTime.of(2024, 4, 5, 6, 7)).locationId(4L).build();
    private final Event event5 = Event.builder().id(5L).caseId(1L).description("Description of event 5")
            .date(LocalDateTime.of(2024, 5, 6, 7, 8)).locationId(5L).build();
    private final List<Event> events = List.of(event1, event2, event3, event4, event5);

    public EventServiceInmemoryImpl(LocationClient locationClient) {
        this.locationClient = locationClient;
    }

    @Override
    public List<Event> findByCaseId(Long caseId) {
        if (caseId == null)
            throw new EventServiceException("The given case id must not be null", HttpStatus.BAD_REQUEST);

        List<Event> eventList = events.stream()
                .filter(item -> Objects.equals(caseId, item.getCaseId()))
                .toList();

        if (!eventList.isEmpty()) {
            for (Event event : eventList) {
                setLocation(event);
            }
        }

        return eventList;
    }

    @Override
    public Event findById(Long id) {
        if (id == null)
            throw new EventServiceException("The given id must not be null", HttpStatus.BAD_REQUEST);

        Event event = events.stream()
                .filter(item -> Objects.equals(id, item.getId()))
                .findFirst()
                .orElseThrow(() -> new EventServiceException("No event found with the given id", HttpStatus.NOT_FOUND));

        setLocation(event);

        return event;
    }

    private void setLocation(Event event) {
        if (event == null)
            return;

        if (event.getLocationId() != null)
            event.setLocation(locationClient.getById(event.getLocationId()));
    }

}
