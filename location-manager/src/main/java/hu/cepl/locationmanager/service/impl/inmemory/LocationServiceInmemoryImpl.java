package hu.cepl.locationmanager.service.impl.inmemory;

import hu.cepl.locationmanager.exception.LocationServiceException;
import hu.cepl.locationmanager.model.Location;
import hu.cepl.locationmanager.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocationServiceInmemoryImpl implements LocationService {

    private final Location location1 = Location.builder().id(1L).country("Country1").postalCode("PostalCode1")
            .city("City1").publicDomainName("PublicDomainName1").publicDomainType("PublicDomainType1")
            .houseNumber("HouserNumber1").latitude(40.7557005).longitude(-73.9767022).build();
    private final Location location2 = Location.builder().id(2L).country("Country2").postalCode("PostalCode2")
            .city("City2").publicDomainName("PublicDomainName2").publicDomainType("PublicDomainType2")
            .houseNumber("HouserNumber2").latitude(51.5005961).longitude(-0.1193458).build();
    private final Location location3 = Location.builder().id(3L).country("Country3").postalCode("PostalCode3")
            .city("City3").publicDomainName("PublicDomainName3").publicDomainType("PublicDomainType3")
            .houseNumber("HouserNumber3").latitude(48.847042).longitude(2.3074038).build();
    private final Location location4 = Location.builder().id(4L).country("Country4").postalCode("PostalCode4")
            .city("City4").publicDomainName("PublicDomainName4").publicDomainType("PublicDomainType4")
            .houseNumber("HouserNumber4").latitude(41.89144).longitude(12.4939227).build();
    private final Location location5 = Location.builder().id(5L).country("Country5").postalCode("PostalCode5")
            .city("City5").publicDomainName("PublicDomainName5").publicDomainType("PublicDomainType5")
            .houseNumber("HouserNumber2").latitude(37.7357378).longitude(113.7982629).build();
    private final List<Location> locations = List.of(location1, location2, location3, location4, location5);

    @Override
    public Location findById(Long id) {
        if (id == null)
            throw new LocationServiceException("The given id must not be null", HttpStatus.BAD_REQUEST);

        return locations.stream()
                .filter(item -> Objects.equals(id, item.getId()))
                .findFirst()
                .orElseThrow(() -> new LocationServiceException("No location found with the given id", HttpStatus.NOT_FOUND));
    }

}
