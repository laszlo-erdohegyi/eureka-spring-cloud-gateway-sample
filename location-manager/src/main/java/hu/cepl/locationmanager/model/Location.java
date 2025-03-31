package hu.cepl.locationmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Long id;
    private String country;
    private String postalCode;
    private String city;
    private String publicDomainName;
    private String publicDomainType;
    private String houseNumber;
    private Double latitude;
    private Double longitude;

    public String getAddress() {
        return country + " " + postalCode + " " + city + ", " + publicDomainName + " " + publicDomainType + " " + houseNumber;
    }

}
