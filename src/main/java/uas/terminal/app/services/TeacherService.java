package uas.terminal.app.services;

import uas.terminal.app.entities.Teacher;

public interface TeacherService {
    public abstract boolean addTeacherService(Teacher teacher);
    public abstract Teacher findOneTeacherByNameService(Teacher teacher);
}
