package uas.terminal.app;

import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.views.UserView;


public class Application {
    public static void main(String[] args) {
        UserView userView = new UserView();
        System.out.println("SMA NEGERI 1 SAMPANG/MADURA | jl. jaksa agung suprapto");
        System.out.println("ASSESSMENT APPLICATION (copyright: 2022)");
        String requestFirst = UserRequest.request("-tekan (0) untuk sig up\n-tekan (1) untuk sign in\nrequest->");
        if (requestFirst.equals("0")) {
            userView.registerUserView();
        } else if (requestFirst.equals("1")) {
            userView.loginUserView();
        }
    }
}
