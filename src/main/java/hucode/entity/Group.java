package hucode.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Component
@Builder
public class Group {
    int id;
    String groups_name;
}
