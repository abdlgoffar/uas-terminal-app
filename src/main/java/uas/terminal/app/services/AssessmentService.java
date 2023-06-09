package uas.terminal.app.services;

import uas.terminal.app.entities.Assessment;

public interface AssessmentService {
    abstract public boolean addAssessmentService(Assessment assessment);
    abstract public Assessment findOneAssessmentByNameService(Assessment assessment);
    abstract public Assessment findOneAssessmentByIdTeacherAndNameService(Assessment assessment);
}
