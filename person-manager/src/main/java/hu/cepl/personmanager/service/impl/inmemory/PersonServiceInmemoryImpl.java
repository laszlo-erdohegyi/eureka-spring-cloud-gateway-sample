package hu.cepl.personmanager.service.impl.inmemory;

import hu.cepl.personmanager.client.LocationClient;
import hu.cepl.personmanager.exception.PersonServiceException;
import hu.cepl.personmanager.model.Person;
import hu.cepl.personmanager.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceInmemoryImpl implements PersonService {

    private final LocationClient locationClient;

    private final Person person1 = Person.builder().id(1L).eventId(1L).givenName("John").surname("Doe").gender("male")
            .dateOfBirth(LocalDate.of(1990, 1, 1)).placeOfBirth("Somewhere")
            .homeAddressId(2L).notificationAddressId(3L).deliveryAddressId(4L).residentialAddressId(5L).build();
    private final Person person2 = Person.builder().id(2L).eventId(1L).givenName("Jane").surname("Doe").gender("female")
            .dateOfBirth(LocalDate.of(1991, 2, 2)).placeOfBirth("Anywhere")
            .homeAddressId(5L).notificationAddressId(2L).deliveryAddressId(3L).residentialAddressId(4L).build();
    private final Person person3 = Person.builder().id(3L).eventId(1L).givenName("Sam").surname("Sample").gender("male")
            .dateOfBirth(LocalDate.of(1992, 3, 3)).placeOfBirth("Everywhere")
            .homeAddressId(4L).notificationAddressId(5L).deliveryAddressId(2L).residentialAddressId(3L).build();
    private final List<Person> events = List.of(person1, person2, person3);

    public PersonServiceInmemoryImpl(LocationClient locationClient) {
        this.locationClient = locationClient;
    }

    @Override
    public List<Person> findByEventId(Long eventId) {
        if (eventId == null)
            throw new PersonServiceException("The given event id must not be null", HttpStatus.BAD_REQUEST);

        List<Person> personList = events.stream()
                .filter(item -> Objects.equals(eventId, item.getEventId()))
                .toList();

        if (!personList.isEmpty()) {
            for (Person person : personList) {
                setLocations(person);
            }
        }

        return personList;
    }

    @Override
    public Person findById(Long id) {
        if (id == null)
            throw new PersonServiceException("The given id must not be null", HttpStatus.BAD_REQUEST);

        Person person = events.stream()
                .filter(item -> Objects.equals(id, item.getId()))
                .findFirst()
                .orElseThrow(() -> new PersonServiceException("No person found with the given id", HttpStatus.NOT_FOUND));

        setLocations(person);

        return person;
    }

    private void setLocations(Person person) {
        if (person == null)
            return;

        if (person.getHomeAddressId() != null)
            person.setHomeAddress(locationClient.getById(person.getHomeAddressId()));
        if (person.getNotificationAddressId() != null)
            person.setNotificationAddress(locationClient.getById(person.getNotificationAddressId()));
        if (person.getDeliveryAddressId() != null)
            person.setDeliveryAddress(locationClient.getById(person.getDeliveryAddressId()));
        if (person.getResidentialAddressId() != null)
            person.setResidentialAddress(locationClient.getById(person.getResidentialAddressId()));
    }

}
