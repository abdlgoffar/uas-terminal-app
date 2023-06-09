package uas.terminal.app.views;

import uas.terminal.app.entities.Assessment;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.AssessmentRepositoryImplement;
import uas.terminal.app.services.AssessmentService;
import uas.terminal.app.services.AssessmentServiceImplement;

public class AssessmentView {
    private AssessmentService assessmentService = new AssessmentServiceImplement(new AssessmentRepositoryImplement());
    public void addAssessmentView(Long idTeacher) {
        String requestAssessment = UserRequest.request("click (0) if want create assessment\nclick (1) if want check assessment\nrequest");
        if (requestAssessment.equals("0")) {
            Assessment assessment = new Assessment();
            assessment.setIdTeacher(idTeacher);
            String requestAssessmentName = UserRequest.request("assessment name");
            assessment.setName(requestAssessmentName);
            boolean addAssessmentService = this.assessmentService.addAssessmentService(assessment);
            if (addAssessmentService) {
                Assessment oneAssessmentByNameService = this.assessmentService.findOneAssessmentByNameService(assessment);
                String requestAmountQuestion = UserRequest.request("how many questions do you want to make in your assessment");
                int n = Integer.parseInt(requestAmountQuestion);
                for (Integer i = 0; i < n; i++) {
                    QuestionView questionView = new QuestionView();
                    questionView.addQuestionView(oneAssessmentByNameService.getId());
                }
            }
        } else if (requestAssessment.equals("1")) {

        }
    }
    public Assessment findOneAssessmentByIdTeacherAndNameView(Long idTeacher, String name) {
        Assessment assessment = new Assessment();
        assessment.setIdTeacher(idTeacher);
        assessment.setName(name);
        Assessment oneAssessmentByIdTeacherAndNameService = this.assessmentService.findOneAssessmentByIdTeacherAndNameService(assessment);
        return oneAssessmentByIdTeacherAndNameService;
    }
}
