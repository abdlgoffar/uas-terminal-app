package uas.terminal.app.entities;

import lombok.Getter;
import lombok.Setter;

public class Assessment {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Long idTeacher;
    @Getter
    @Setter
    private String name;
}
