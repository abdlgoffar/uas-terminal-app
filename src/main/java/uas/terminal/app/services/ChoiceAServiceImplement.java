package uas.terminal.app.services;

import uas.terminal.app.entities.ChoiceA;
import uas.terminal.app.repositories.ChoiceARepository;

public class ChoiceAServiceImplement implements ChoiceAService{
    private ChoiceARepository choiceARepository;

    public ChoiceAServiceImplement(ChoiceARepository choiceARepository) {
        this.choiceARepository = choiceARepository;
    }

    @Override
    public boolean addChoiceAService(ChoiceA choiceA) {
        boolean addChoiceARepos = this.choiceARepository.addChoiceARepos(choiceA);
        if (addChoiceARepos) return true;
        return false;
    }

    @Override
    public ChoiceA findOneChoiceAByIdQuestionService(ChoiceA choiceA) {
        ChoiceA oneChoiceAByIdQuestionRepos = this.choiceARepository.findOneChoiceAByIdQuestionRepos(choiceA);
        if (oneChoiceAByIdQuestionRepos != null) return oneChoiceAByIdQuestionRepos;
        return null;
    }

    @Override
    public boolean updateOneChoiceAByIdQuestionService(ChoiceA choiceA) {
        boolean updateOneChoiceAByIdQuestionRepos = this.choiceARepository.updateOneChoiceAByIdQuestionRepos(choiceA);
        if (updateOneChoiceAByIdQuestionRepos) return true;
        return false;
    }

    @Override
    public ChoiceA findOneChoiceAValueStatusTrueByIdQuestionService(ChoiceA choiceA) {
        ChoiceA oneChoiceAValueStatusTrueByIdQuestionRepos = this.choiceARepository.findOneChoiceAValueStatusTrueByIdQuestionRepos(choiceA);
        if (oneChoiceAValueStatusTrueByIdQuestionRepos != null) return  oneChoiceAValueStatusTrueByIdQuestionRepos;
        return null;
    }
}
