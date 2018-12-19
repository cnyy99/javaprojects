package domain;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String id;

    private String username;

    private String password;
}
