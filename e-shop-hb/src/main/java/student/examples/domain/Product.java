package student.examples.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity(name = "products")
public class Product {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Setter
    @Column(length = 120)
    private String name;

    @Getter
    @Setter
    @Column(length = 160)
    private String image;

    @Getter
    @Setter
    @ManyToOne
    private Category category;

    @Getter
    @Setter
    @OneToOne
    private Money price;

    public Product(String name, String image) {
        this.name = name;
        this.image = image;
    }
    
}
