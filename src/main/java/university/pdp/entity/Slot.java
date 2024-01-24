package university.pdp.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Slot {
    private Integer tableNumber;
    private String date;
    private String time;
}
