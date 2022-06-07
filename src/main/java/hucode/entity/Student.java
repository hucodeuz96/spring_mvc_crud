package hucode.entity;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Component
public class Student {
    int id;
    String name;
    String email;
    int  groups_id;
}
