package uas.terminal.app.services;

import uas.terminal.app.entities.ChoiceA;

public interface ChoiceAService {
    public abstract boolean addChoiceAService(ChoiceA choiceA);
    public abstract ChoiceA findOneChoiceAByIdQuestionService(ChoiceA choiceA);
    public abstract boolean updateOneChoiceAByIdQuestionService(ChoiceA choiceA);

    public abstract ChoiceA findOneChoiceAValueStatusTrueByIdQuestionService(ChoiceA choiceA);
}
