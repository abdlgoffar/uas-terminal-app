package uas.terminal.app.views;

import uas.terminal.app.entities.Teacher;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.TeacherRepositoryImplement;
import uas.terminal.app.services.TeacherService;
import uas.terminal.app.services.TeacherServiceImplement;

public class TeacherView {

    private TeacherService teacherService = new TeacherServiceImplement(new TeacherRepositoryImplement());

    public Long addTeacherView() {
        String requestTeacherName = UserRequest.request("name teacher");
        Teacher teacher = new Teacher();
        teacher.setName(requestTeacherName);
        this.teacherService.addTeacherService(teacher);
        Teacher oneTeacherByNameService = this.teacherService.findOneTeacherByNameService(teacher);
        return oneTeacherByNameService.getId();
    }
    public Teacher findOneTeacherView(String name) {
        Teacher teacher = new Teacher();
        teacher.setName(name);;
        Teacher oneTeacherByNameService = this.teacherService.findOneTeacherByNameService(teacher);
        return  oneTeacherByNameService;
    }
}
