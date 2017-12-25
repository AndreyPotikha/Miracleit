package miracle.model;

import lombok.*;
import miracle.util.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {
    private String name;
    private LocalDateTime localDateTime;
    private Status status;
    private User performer;

}
