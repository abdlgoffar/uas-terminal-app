package uas.terminal.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Long idTeacher;

    @Getter
    @Setter
    private Long idStudent;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;


}
