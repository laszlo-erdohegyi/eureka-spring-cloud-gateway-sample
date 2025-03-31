package hu.cepl.personmanager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private Long eventId;
    private String givenName;
    private String surname;
    private String gender;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Long homeAddressId;
    private Location homeAddress;
    private Long notificationAddressId;
    private Location notificationAddress;
    private Long deliveryAddressId;
    private Location deliveryAddress;
    private Long residentialAddressId;
    private Location residentialAddress;

    public String getFullName() {
        return givenName + " " + surname;
    }

}
