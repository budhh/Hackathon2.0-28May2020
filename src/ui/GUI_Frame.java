package ui;

import model.Message;
import model.MessageLog;
import model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

public class GUI_Frame extends JPanel {

    private JTextField enteredMessage;
    private MessageLog messageLog;
    private final User user;
    private JPanel messageLogPanel;

    public GUI_Frame(User user) {
        this.user = user;

        JPanel organizer = new JPanel();
        messageLog = new MessageLog();
        messageLogPanel = new JPanel();

        messageLogPanel.setPreferredSize(new Dimension(300, 400));
        messageLogPanel.setLayout(new BoxLayout(messageLogPanel, BoxLayout.Y_AXIS));
        messageLogPanel.setBorder(new LineBorder(Color.red, 2, true));

        organizer.setLayout(new BoxLayout(organizer, BoxLayout.Y_AXIS));
        organizer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        organizer.add(messageLogPanel);
        organizer.add(messageInp());

        add(organizer);
    }

    private void updateMessageLog(){
        messageLogPanel.removeAll();

        Iterator<Message> iter = messageLog.getIterator();

        for (int i = 0; iter.hasNext() && i < 10; i++) {
            messageLogPanel.add(messagePanel(iter.next()));
        }

        revalidate();
        repaint();
    }

    private JPanel messagePanel(Message message) {
        JPanel messagePanel = new JPanel();
        messagePanel.setBorder(new LineBorder(Color.black, 2, true));
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JLabel username = new JLabel();
        username.setText(message.getUser().toString());
        JLabel messageBody = new JLabel();
        messageBody.setText(message.getMessage());

        messagePanel.add(username);
        messagePanel.add(messageBody);

        return messagePanel;
    }

    private JPanel messageInp(){
        JPanel messageInp = new JPanel();

        JButton messageButton = new JButton("Enter");

        enteredMessage = new JTextField();
        enteredMessage.setPreferredSize( new Dimension( 200, 24 ) );
        enteredMessage.addKeyListener(new EnterListener());

        messageButton.addActionListener(new TextListener());

        messageInp.setLayout(new BoxLayout(messageInp, BoxLayout.X_AXIS));
        messageInp.setBorder(new TitledBorder("Enter your message and press 'Enter'"));
        messageInp.add(enteredMessage);
        messageInp.add(messageButton);

        return messageInp;
    }

    private void addMessage(){
        String messageText = enteredMessage.getText();
        if (!messageText.equals("")) {
            messageLog.addMessageToLog(new Message(messageText, user));
        }
        enteredMessage.setText("");
        updateMessageLog();
    }

    private class TextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addMessage();
        }
    }

    private class EnterListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                addMessage();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}


        @Override
        public void keyTyped(KeyEvent e) {}

    }
}
