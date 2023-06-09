package uas.terminal.app.views;

import uas.terminal.app.entities.ChoiceA;
import uas.terminal.app.entities.ChoiceB;
import uas.terminal.app.entities.ChoiceC;
import uas.terminal.app.entities.Question;
import uas.terminal.app.helpers.Count;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.QuestionRepositoryImplement;
import uas.terminal.app.services.QuestionService;
import uas.terminal.app.services.QuestionServiceImplement;

import java.util.Stack;
public class QuestionView {
    private QuestionService questionService = new QuestionServiceImplement(new QuestionRepositoryImplement());
    public void addQuestionView(Long idAssessment) {
        String requestQuestionName = UserRequest.request("create your question");
        Question question = new Question();
        question.setIdAssessment(idAssessment);
        question.setName(requestQuestionName);
        boolean addQuestionService = this.questionService.addQuestionService(question);
        if (addQuestionService) {
            Question oneQuestionByNameService = this.questionService.findOneQuestionByNameService(question);
            ChoiceAView choiceAView = new ChoiceAView();
            choiceAView.addChoiceAView(oneQuestionByNameService.getId());
            ChoiceBView choiceBView = new ChoiceBView();
            choiceBView.addChoiceBView(oneQuestionByNameService.getId());
            ChoiceCView choiceCView = new ChoiceCView();
            choiceCView.addChoiceCView(oneQuestionByNameService.getId());
            String requestCorrectAnswer = UserRequest.request("choice with the correct answer");
            if (requestCorrectAnswer.equals("a")) {
                ChoiceAView choiceAView1 = new ChoiceAView();
                choiceAView1.updateOneChoiceAByIdQuestionView(oneQuestionByNameService.getId());
            } else if (requestCorrectAnswer.equals("b")) {
                ChoiceBView choiceBView1 = new ChoiceBView();
                choiceBView1.updateOneChoiceBByIdQuestionView(oneQuestionByNameService.getId());
            } else if (requestCorrectAnswer.equals("c")) {
                ChoiceCView choiceCView1 = new ChoiceCView();
                choiceCView1.updateOneChoiceCByIdQuestionView(oneQuestionByNameService.getId());
            }
        }
    }
    public void findAllQuestionByIdAssessment(Long idAssessment) {
        Question question = new Question();
        ChoiceAView choiceAView = new ChoiceAView();
        ChoiceBView choiceBView = new ChoiceBView();
        ChoiceCView choiceCView = new ChoiceCView();
        question.setIdAssessment(idAssessment);
        Stack<Question> allQuestionByIdAssessmentService = this.questionService.findAllQuestionByIdAssessmentService(question);
        Integer number = 1;
        Integer questionsAnsweredCorrectly = 0;
        int numbersOfQuestion = allQuestionByIdAssessmentService.size();
        QuestionView questionView = new QuestionView();
        for (Integer i = 0; i < allQuestionByIdAssessmentService.size(); i++) {
            System.out.println(number + ". " + allQuestionByIdAssessmentService.get(i).getName());
            choiceAView.findOneChoiceAByIdQuestionView(allQuestionByIdAssessmentService.get(i).getId());
            choiceBView.findOneChoiceBByIdQuestionView(allQuestionByIdAssessmentService.get(i).getId());
            choiceCView.findOneChoiceCByIdQuestionView(allQuestionByIdAssessmentService.get(i).getId());
            String requestAnswer = UserRequest.request("your answer");
            if (requestAnswer.equals(questionView.correctAnswer(allQuestionByIdAssessmentService.get(i).getId()))) {
                questionsAnsweredCorrectly++;
            }
            number++;
        }
        Integer value = Count.valueCalculation(numbersOfQuestion, questionsAnsweredCorrectly);
        System.out.println("nilai " + value);
    }

    public String correctAnswer(Long idQuestion) {
        ChoiceAView choiceAView = new ChoiceAView();
        ChoiceA oneChoiceAValueStatusTrueByIdQuestionView = choiceAView.findOneChoiceAValueStatusTrueByIdQuestionView(idQuestion);
        ChoiceBView choiceBView = new ChoiceBView();
        ChoiceB oneChoiceBValueStatusTrueByIdQuestionView = choiceBView.findOneChoiceBValueStatusTrueByIdQuestionView(idQuestion);
        ChoiceCView choiceCView = new ChoiceCView();
        ChoiceC oneChoiceCValueStatusTrueByIdQuestionView = choiceCView.findOneChoiceCValueStatusTrueByIdQuestionView(idQuestion);
        if (oneChoiceAValueStatusTrueByIdQuestionView != null) {
            return "a";
        } else if (oneChoiceBValueStatusTrueByIdQuestionView != null) {
            return "b";
        } else if (oneChoiceCValueStatusTrueByIdQuestionView != null) {
            return "c";
        }
        return "nothing";
    }
}
