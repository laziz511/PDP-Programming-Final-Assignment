package university.pdp.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Reservation {
    private String customerName;
    private String date;
    private String time;
    private Integer peopleCount;
    private List<Meal> meals;
    private Integer tableNumber;
    private Double price;
}
