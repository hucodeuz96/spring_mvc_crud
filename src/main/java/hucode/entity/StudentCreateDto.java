package hucode.entity;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Component
public class StudentCreateDto {
    int id;
    String name;
    String email;
    String  groups_name;
}
