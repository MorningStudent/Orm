package student.examples.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Embeddable
public class Address {
    
    @Getter
    @Setter
    @Column(length = 50)
    private String city;

    @Getter
    @Setter
    @Column(length = 100)
    private String street;

    @Getter
    @Setter
    @Column(length = 50)
    private String number;

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

}
