package ui;

import model.Message;
import model.MessageLog;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();

    User user;
    MessageLog messageLog = new MessageLog();

    private String enteredUsername;
    private String usernameDisplay;
    JLabel usernameLabel = new JLabel("Enter Your Username: " + enteredUsername);
    private JTextField usernameField = new JTextField();
    private JButton usernameButton = new JButton("Set");

    private String enteredMessage;
    private String messageDisplay;
    JLabel messageLabel = new JLabel("Enter your message and press 'Enter'");
    private JTextField messageField = new JTextField();
    private JButton messageButton = new JButton("Enter");

    private ActionListener usernameAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            enteredUsername = usernameField.getText();
            user = new User(enteredUsername);
            usernameDisplay = usernameField.getText();
            usernameLabel.setText("Enter Your Username: " + usernameDisplay);

        }
    };

    private ActionListener messageAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            enteredMessage = messageField.getText();
            messageDisplay = messageField.getText();
            messageLabel.setText("Enter your message and press 'Enter'");
            Message message = new Message(enteredMessage, user);
            messageLog.addMessageToLog(message);

        }
    };

    public GUI() {
        // Set Up JPanel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1));

        // Set Up Username
        panel.add(usernameLabel);
        panel.add(usernameField);
        usernameButton.addActionListener(usernameAL);
        panel.add(usernameButton);

        // Set Up Editable Text Area
        panel.add(messageLabel);
        panel.add(messageField);
        usernameButton.addActionListener(messageAL);
        panel.add(messageButton);

//        // Questions
//        JLabel questionsLabel = new JLabel("Questions: ");
//        panel.add(questionsLabel);
//        questionsArea.setEditable(false);
//        panel.add(questionsScroll);
//
//        // Answers
//        JLabel answersLabel = new JLabel("Answers: ");
//        panel.add(answersLabel);
//        answersArea.setEditable(false);
//        panel.add(answersScroll);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MessagingApp");
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
