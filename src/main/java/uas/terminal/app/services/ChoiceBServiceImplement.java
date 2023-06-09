package uas.terminal.app.services;

import uas.terminal.app.entities.ChoiceB;
import uas.terminal.app.repositories.ChoiceBRepository;

public class ChoiceBServiceImplement implements ChoiceBService{
    private ChoiceBRepository choiceBRepository;

    public ChoiceBServiceImplement(ChoiceBRepository choiceBRepository) {
        this.choiceBRepository = choiceBRepository;
    }

    @Override
    public boolean addChoiceBService(ChoiceB choiceB) {
        boolean addChoiceBRepos = this.choiceBRepository.addChoiceBRepos(choiceB);
        if (addChoiceBRepos) return true;
        return false;
    }

    @Override
    public ChoiceB findOneChoiceBByIdQuestionService(ChoiceB choiceB) {
        ChoiceB oneChoiceBByIdQuestionRepos = this.choiceBRepository.findOneChoiceBByIdQuestionRepos(choiceB);
        if (oneChoiceBByIdQuestionRepos != null) return oneChoiceBByIdQuestionRepos;
        return null;
    }

    @Override
    public boolean updateOneChoiceBByIdQuestionService(ChoiceB choiceB) {
        boolean updateOneChoiceBByIdQuestionRepos = this.choiceBRepository.updateOneChoiceBByIdQuestionRepos(choiceB);
        if (updateOneChoiceBByIdQuestionRepos) return true;
        return false;
    }

    @Override
    public ChoiceB findOneChoiceBValueStatusTrueByIdQuestionService(ChoiceB choiceB) {
        ChoiceB oneChoiceBValueStatusTrueByIdQuestionRepos = this.choiceBRepository.findOneChoiceBValueStatusTrueByIdQuestionRepos(choiceB);
        if (oneChoiceBValueStatusTrueByIdQuestionRepos != null) return oneChoiceBValueStatusTrueByIdQuestionRepos;
        return null;
    }
}
