package uas.terminal.app.repositories;

import uas.terminal.app.entities.ChoiceA;


public interface ChoiceARepository {
    public abstract boolean addChoiceARepos(ChoiceA choiceA);
    public abstract ChoiceA findOneChoiceAByIdQuestionRepos(ChoiceA choiceA);
    public abstract boolean updateOneChoiceAByIdQuestionRepos(ChoiceA choiceA);

    public abstract ChoiceA findOneChoiceAValueStatusTrueByIdQuestionRepos(ChoiceA choiceA);

}
