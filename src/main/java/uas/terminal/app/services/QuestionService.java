package uas.terminal.app.services;

import uas.terminal.app.entities.Question;

import java.util.Stack;

public interface QuestionService {
    public abstract boolean addQuestionService(Question question);
    public abstract Question findOneQuestionByNameService(Question question);

    public  abstract Stack<Question> findAllQuestionByIdAssessmentService(Question question);
}
