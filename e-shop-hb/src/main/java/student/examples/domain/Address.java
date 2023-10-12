package student.examples.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Entity(name = "adresses")
public class Address {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;
    
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

    @Getter
    @Setter
    @ManyToOne
    private Client client;

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

}
