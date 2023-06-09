package uas.terminal.app.services;

import uas.terminal.app.entities.ChoiceC;
import uas.terminal.app.repositories.ChoiceCRepository;


public class ChoiceCServiceImplement implements ChoiceCService{

    private ChoiceCRepository choiceCRepository;

    public ChoiceCServiceImplement(ChoiceCRepository choiceCRepository) {
        this.choiceCRepository = choiceCRepository;
    }

    @Override
    public boolean addChoiceCService(ChoiceC choiceC) {
        boolean addChoiceCRepos = this.choiceCRepository.addChoiceCRepos(choiceC);
        if (addChoiceCRepos) return true;
        return false;
    }

    @Override
    public ChoiceC findOneChoiceCByIdQuestionService(ChoiceC choiceC) {
        ChoiceC oneChoiceCByIdQuestionRepos = this.choiceCRepository.findOneChoiceCByIdQuestionRepos(choiceC);
        if (oneChoiceCByIdQuestionRepos != null) return  oneChoiceCByIdQuestionRepos;
        return null;
    }

    @Override
    public boolean updateOneChoiceCByIdQuestionService(ChoiceC choiceC) {
        boolean updateOneChoiceCByIdQuestionRepos = this.choiceCRepository.updateOneChoiceCByIdQuestionRepos(choiceC);
        if (updateOneChoiceCByIdQuestionRepos) return true;
        return false;
    }

    @Override
    public ChoiceC findOneChoiceCValueStatusTrueByIdQuestionService(ChoiceC choiceC) {
        ChoiceC oneChoiceCValueStatusTrueByIdQuestionRepos = this.choiceCRepository.findOneChoiceCValueStatusTrueByIdQuestionRepos(choiceC);
        if (oneChoiceCValueStatusTrueByIdQuestionRepos != null) return oneChoiceCValueStatusTrueByIdQuestionRepos;
        return null;
    }
}
