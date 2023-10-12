package student.examples.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity(name = "clients")
public class Client {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Setter
    @Column(length = 80)
    private String fullName;

    @Getter
    @Setter
    @Column(length = 160)
    private String image;

    @Getter
    @Setter
    @Column(length = 20)
    private List<String> contactPhones = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany
    private List<Cart> carts = new ArrayList<>();

    public Client(String fullName) {
        this.fullName = fullName;
    }
    
}
