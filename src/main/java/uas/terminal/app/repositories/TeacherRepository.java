package uas.terminal.app.repositories;

import uas.terminal.app.entities.Teacher;

public interface TeacherRepository {
    public abstract boolean addTeacherRepos(Teacher teacher);

    public abstract Teacher findOneTeacherByNameRepos(Teacher teacher);
}
