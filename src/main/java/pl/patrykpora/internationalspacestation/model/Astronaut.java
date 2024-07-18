package pl.patrykpora.internationalspacestation.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "astronauts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Astronaut extends BaseEntity {

    private String name;

    private String craft;

}
