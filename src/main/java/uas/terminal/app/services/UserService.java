package uas.terminal.app.services;

import uas.terminal.app.entities.User;

public interface UserService {
    public abstract boolean addUserService(User user);
    public abstract boolean registerUserTeacherService(User user);
    public abstract boolean registerUserStudentService(User user);
    public abstract boolean loginUserTeacherService(User user);
    public abstract boolean loginUserStudentService(User user);

}
