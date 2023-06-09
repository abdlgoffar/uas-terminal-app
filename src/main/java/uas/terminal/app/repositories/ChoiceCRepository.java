package uas.terminal.app.repositories;

import uas.terminal.app.entities.ChoiceC;

public interface ChoiceCRepository {
    public abstract boolean addChoiceCRepos(ChoiceC choiceC);
    public abstract ChoiceC findOneChoiceCByIdQuestionRepos(ChoiceC choiceC);
    public abstract boolean updateOneChoiceCByIdQuestionRepos(ChoiceC choiceC);

    public abstract ChoiceC findOneChoiceCValueStatusTrueByIdQuestionRepos(ChoiceC choiceC);
}
