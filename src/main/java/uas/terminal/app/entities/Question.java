package uas.terminal.app.entities;

import lombok.Getter;
import lombok.Setter;

public class Question {
    public Question() {
    }

    public Question(Long id, Long idAssessment, String name) {
        this.id = id;
        this.idAssessment = idAssessment;
        this.name = name;
    }

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Long idAssessment;
    @Getter
    @Setter
    private String name;
}
