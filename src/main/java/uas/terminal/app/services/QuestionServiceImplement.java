package uas.terminal.app.services;

import uas.terminal.app.entities.Question;
import uas.terminal.app.repositories.QuestionRepository;

import java.util.Stack;

public class QuestionServiceImplement implements QuestionService{
    private QuestionRepository questionRepository;

    public QuestionServiceImplement(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public boolean addQuestionService(Question question) {
        boolean addQuestionRepos = this.questionRepository.addQuestionRepos(question);
        if (addQuestionRepos) return true;
        return false;
    }

    @Override
    public Question findOneQuestionByNameService(Question question) {
        Question oneQuestionByNameRepos = this.questionRepository.findOneQuestionByNameRepos(question);
        if (oneQuestionByNameRepos != null) return oneQuestionByNameRepos;
        return null;
    }

    @Override
    public Stack<Question> findAllQuestionByIdAssessmentService(Question question) {
        Stack<Question> allQuestionByIdAssessmentRepos = this.questionRepository.findAllQuestionByIdAssessmentRepos(question);
        if (allQuestionByIdAssessmentRepos != null) return allQuestionByIdAssessmentRepos;
        return null;
    }
}
