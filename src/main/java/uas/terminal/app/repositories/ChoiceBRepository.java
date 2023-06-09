package uas.terminal.app.repositories;

import uas.terminal.app.entities.ChoiceB;

public interface ChoiceBRepository {
    public abstract boolean addChoiceBRepos(ChoiceB choiceB);
    public abstract ChoiceB findOneChoiceBByIdQuestionRepos(ChoiceB choiceB);

    public abstract boolean updateOneChoiceBByIdQuestionRepos(ChoiceB choiceB);

    public abstract ChoiceB findOneChoiceBValueStatusTrueByIdQuestionRepos(ChoiceB choiceB);
}
