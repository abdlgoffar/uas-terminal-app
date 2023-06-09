package uas.terminal.app.views;


import uas.terminal.app.entities.ChoiceC;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.ChoiceCRepositoryImplement;
import uas.terminal.app.services.ChoiceCService;
import uas.terminal.app.services.ChoiceCServiceImplement;

public class ChoiceCView {
    private ChoiceCService choiceCService = new ChoiceCServiceImplement(new ChoiceCRepositoryImplement());

    public void addChoiceCView(Long idQuestion) {
        String requestChoiceCName = UserRequest.request("fill chose c");
        ChoiceC choiceC = new ChoiceC();
        choiceC.setIdQuestion(idQuestion);
        choiceC.setName(requestChoiceCName);
        this.choiceCService.addChoiceCService(choiceC);
    }
    public void findOneChoiceCByIdQuestionView(Long idQuestion) {
        ChoiceC choiceC = new ChoiceC();
        choiceC.setIdQuestion(idQuestion);
        ChoiceC oneChoiceCByIdQuestionService = this.choiceCService.findOneChoiceCByIdQuestionService(choiceC);
        System.out.println("c. " + oneChoiceCByIdQuestionService.getName());
    }
    public void updateOneChoiceCByIdQuestionView(Long idQuestion) {
        ChoiceC choiceC = new ChoiceC();
        choiceC.setIdQuestion(idQuestion);
        this.choiceCService.updateOneChoiceCByIdQuestionService(choiceC);
    }
    public ChoiceC findOneChoiceCValueStatusTrueByIdQuestionView(Long idQuestion) {
        ChoiceC choiceC = new ChoiceC();
        choiceC.setIdQuestion(idQuestion);
        ChoiceC oneChoiceCValueStatusTrueByIdQuestionService = this.choiceCService.findOneChoiceCValueStatusTrueByIdQuestionService(choiceC);
        return oneChoiceCValueStatusTrueByIdQuestionService;
    }
}
