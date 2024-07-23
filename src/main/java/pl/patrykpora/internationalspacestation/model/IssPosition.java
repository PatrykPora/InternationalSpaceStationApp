package pl.patrykpora.internationalspacestation.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IssPosition {


    private double longitude;
    private double latitude;
    private long timestamp;
    private double speedOfIss;

}
