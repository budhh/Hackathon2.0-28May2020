package ui;

import model.Message;
import model.MessageLog;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ClientGUI extends JPanel {

    private JTextField enteredMessage;
    private final MessageLog messageLog;
    private final User user;
    private final JPanel messageLogPanel;

    public ClientGUI() {
        user = new User();
        messageLog = new MessageLog();
        messageLogPanel = new JPanel();
        JPanel organizer = new JPanel();

        organizer.setLayout(new BorderLayout());
        organizer.setBorder(new EmptyBorder(0, 0, 0, 0));
        organizer.add(getMessageLogPanel(), BorderLayout.NORTH);
        organizer.add(getMessageInpPanel(), BorderLayout.SOUTH);
        organizer.setBackground(new Color(0xffffff));
        setLayout(new FlowLayout());
        add(organizer);
    }

    private JPanel getMessageLogPanel() {
        messageLogPanel.setPreferredSize(new Dimension(400, 400));
        messageLogPanel.setLayout(new FlowLayout());
        messageLogPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        return messageLogPanel;
    }

    private void updateMessageLog() {
        messageLogPanel.removeAll();
        List<Message> last10 = messageLog.getLastN();
        for (Message message: last10) {
            messageLogPanel.add(messagePanel(message));
        }
        revalidate();
        repaint();
    }

    private JPanel messagePanel(Message message) {
        JPanel panel = new JPanel();
        JLabel username = new JLabel();
        JTextArea messageBody = new JTextArea();
        panel.setPreferredSize(new Dimension(400, 50));
        panel.setBorder(new LineBorder(new Color(0xa4b0be), 1, true));
        panel.setLayout(new GridLayout(2, 0));

        username.setBorder(new EmptyBorder(5, 0, 5, 0));
        username.setText(message.getUser().toString());

        messageBody.setText(message.getMessageBody());
        messageBody.setWrapStyleWord(true);
        messageBody.setLineWrap(true);
        messageBody.setOpaque(false);
        messageBody.setEditable(false);
        messageBody.setFocusable(false);
        messageBody.setBackground(new Color(0xf1f2f6));
        messageBody.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        messageBody.setBorder(new EmptyBorder(5, 0, 5, 0));

        panel.add(username, BorderLayout.NORTH);
        panel.add(messageBody, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel getMessageInpPanel() {
        JPanel messageInp = new JPanel();
        JButton messageButton = new JButton("Enter");

        enteredMessage = new JTextField();
        enteredMessage.setPreferredSize(new Dimension(200, 30));

        enteredMessage.addKeyListener(new EnterListener());
        messageButton.addActionListener(new TextListener());

        messageInp.setLayout(new BoxLayout(messageInp, BoxLayout.X_AXIS));
        messageInp.setBorder(new EmptyBorder(0, 0, 0 ,0));
        messageInp.add(enteredMessage);
        messageInp.add(messageButton);

        return messageInp;
    }

    private void addMessage() {
        String messageText = enteredMessage.getText();
        if (!messageText.equals("")) {
            messageLog.addMessageToLog(new Message(messageText, user));
            enteredMessage.setText("");
            updateMessageLog();
        }
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
