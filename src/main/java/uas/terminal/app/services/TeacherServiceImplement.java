package uas.terminal.app.services;

import uas.terminal.app.entities.Teacher;
import uas.terminal.app.repositories.TeacherRepository;

public class TeacherServiceImplement implements TeacherService{
    private TeacherRepository teacherRepository;

    public TeacherServiceImplement(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public boolean addTeacherService(Teacher teacher) {
        boolean addTeacherRepos = teacherRepository.addTeacherRepos(teacher);
        if (addTeacherRepos) return true;
        return false;
    }

    @Override
    public Teacher findOneTeacherByNameService(Teacher teacher) {
        Teacher oneTeacherByNameRepos = this.teacherRepository.findOneTeacherByNameRepos(teacher);
        if (oneTeacherByNameRepos != null) return oneTeacherByNameRepos;
        return null;
    }
}
