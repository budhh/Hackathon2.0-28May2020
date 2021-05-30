package model;

import java.util.ArrayList;
import java.util.List;

public class MessageLog {

    List<Message> messageLog;

    public MessageLog() {
        this.messageLog = new ArrayList<>();
    }

    public void addMessageToLog(Message message) {
        this.messageLog.add(message);
    }

    public List<Message> getLastN() {
        return getLastN(10);
    }

    public List<Message> getLastN(int n) {
        int lastIndex = this.messageLog.size();
        return this.messageLog.subList(Math.max(0, lastIndex - n - 1), lastIndex);
    }
}
