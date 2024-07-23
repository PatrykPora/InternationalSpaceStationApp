package pl.patrykpora.internationalspacestation.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "speeds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class IssSpeed extends BaseEntity {


    private double speed;
    private LocalDate dateOfMeasure;


}
