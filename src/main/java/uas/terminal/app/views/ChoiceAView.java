package uas.terminal.app.views;

import uas.terminal.app.entities.ChoiceA;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.ChoiceARepositoryImplement;
import uas.terminal.app.services.ChoiceAService;
import uas.terminal.app.services.ChoiceAServiceImplement;

public class ChoiceAView {
    private ChoiceAService choiceAService = new ChoiceAServiceImplement(new ChoiceARepositoryImplement());
    public void addChoiceAView(Long idQuestion) {
        String requestChoiceAName = UserRequest.request("fill choose a");
        ChoiceA choiceA = new ChoiceA();
        choiceA.setIdQuestion(idQuestion);
        choiceA.setName(requestChoiceAName);
        this.choiceAService.addChoiceAService(choiceA);
    }
    public void findOneChoiceAByIdQuestionView(Long idQuestion) {
        ChoiceA choiceA = new ChoiceA();
        choiceA.setIdQuestion(idQuestion);
        ChoiceA oneChoiceAByIdQuestionService = this.choiceAService.findOneChoiceAByIdQuestionService(choiceA);
        System.out.println("a. " + oneChoiceAByIdQuestionService.getName());
    }
    public void updateOneChoiceAByIdQuestionView(Long idQuestion) {
        ChoiceA choiceA = new ChoiceA();
        choiceA.setIdQuestion(idQuestion);
        this.choiceAService.updateOneChoiceAByIdQuestionService(choiceA);
    }

    public ChoiceA findOneChoiceAValueStatusTrueByIdQuestionView(Long idQuestion) {
        ChoiceA choiceA = new ChoiceA();
        choiceA.setIdQuestion(idQuestion);
        ChoiceA oneChoiceAValueStatusTrueByIdQuestionService = this.choiceAService.findOneChoiceAValueStatusTrueByIdQuestionService(choiceA);
        return oneChoiceAValueStatusTrueByIdQuestionService;
    }
}
