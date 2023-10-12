package student.examples.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity(name = "money")
public class Money {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Setter
    private int amount;

    @Getter
    @Setter
    @Column(length = 4)
    private String charCode;

    // @Getter
    // @Setter
    // @ManyToOne
    // @JoinColumn(name = "product_id")
    // private Product product;

    public Money(int amount, String charCode) {
        this.amount = amount;
        this.charCode = charCode;
    }

}
