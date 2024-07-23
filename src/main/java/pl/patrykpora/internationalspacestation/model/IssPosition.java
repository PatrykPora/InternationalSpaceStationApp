package pl.patrykpora.internationalspacestation.model;


import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "issPositions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class IssPosition extends BaseEntity{


    private double longitude;
    private double latitude;
    private long timestamp;

}
