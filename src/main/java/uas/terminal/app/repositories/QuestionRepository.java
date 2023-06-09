package uas.terminal.app.repositories;

import uas.terminal.app.entities.Question;

import java.util.Stack;

public interface QuestionRepository {
    public abstract boolean addQuestionRepos(Question question);
    public abstract Question findOneQuestionByNameRepos(Question question);
    public  abstract Stack<Question> findAllQuestionByIdAssessmentRepos(Question question);
}
