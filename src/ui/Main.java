package ui;

import model.User;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        User user = new User();
        frame.setTitle(user.toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI_Frame(user));
        frame.pack();
        frame.setVisible(true);
    }
}


