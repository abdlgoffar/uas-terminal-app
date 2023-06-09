package uas.terminal.app.services;

import uas.terminal.app.entities.ChoiceC;

public interface ChoiceCService {
    public abstract boolean addChoiceCService(ChoiceC choiceC);
    public abstract ChoiceC findOneChoiceCByIdQuestionService(ChoiceC choiceC);
    public abstract boolean updateOneChoiceCByIdQuestionService(ChoiceC choiceC);

    public abstract ChoiceC findOneChoiceCValueStatusTrueByIdQuestionService(ChoiceC choiceC);
}
