package student.examples.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity(name = "currencies")
public class Currency {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Setter
    @Column(length = 60)
    private String name;

    @Getter
    @Setter
    @Column(length = 4)
    private String charCode;

    @Getter
    @Setter
    private int numCode;

    @Getter
    @Setter
    private float value;

    public Currency(String name, String charCode, int numCode, float value) {
        this.name = name;
        this.charCode = charCode;
        this.numCode = numCode;
        this.value = value;
    }

}
