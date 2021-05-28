package model;

import java.util.ArrayList;

public class MessageLog {

    ArrayList<Message> messageLog;

    MessageLog() {
        this.messageLog = new ArrayList<>();
    }

    public void addMessageToLog(Message message) {
        messageLog.add(message);
    }
}
