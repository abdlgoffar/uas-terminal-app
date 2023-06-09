package uas.terminal.app.repositories;

import uas.terminal.app.entities.Assessment;

public interface AssessmentRepository {
    public abstract boolean addAssessmentRepos(Assessment assessment);
    public abstract Assessment findOneAssessmentByNameRepos(Assessment assessment);
    public  abstract Assessment findOneAssessmentByIdTeacherAndNameRepos(Assessment assessment);
}
