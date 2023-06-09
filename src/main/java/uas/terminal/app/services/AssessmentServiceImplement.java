package uas.terminal.app.services;

import uas.terminal.app.entities.Assessment;
import uas.terminal.app.repositories.AssessmentRepository;

public class AssessmentServiceImplement implements AssessmentService {
    private AssessmentRepository assessmentRepository;

    public AssessmentServiceImplement(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public boolean addAssessmentService(Assessment assessment) {
        boolean addAssessmentRepos = this.assessmentRepository.addAssessmentRepos(assessment);
        if (addAssessmentRepos) return true;
        return false;
    }

    @Override
    public Assessment findOneAssessmentByNameService(Assessment assessment) {
        Assessment oneAssessmentByNameRepos = this.assessmentRepository.findOneAssessmentByNameRepos(assessment);
        if (oneAssessmentByNameRepos != null) return oneAssessmentByNameRepos;
        return null;
    }

    @Override
    public Assessment findOneAssessmentByIdTeacherAndNameService(Assessment assessment) {
        Assessment oneAssessmentByIdTeacherAndNameRepos = this.assessmentRepository.findOneAssessmentByIdTeacherAndNameRepos(assessment);
        if (oneAssessmentByIdTeacherAndNameRepos != null) return  oneAssessmentByIdTeacherAndNameRepos;
        return null;
    }
}
