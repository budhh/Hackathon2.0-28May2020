package model;

import java.util.ArrayDeque;
import java.util.Iterator;

public class MessageLog {

    ArrayDeque<Message> messageLog;

    public MessageLog() {
        this.messageLog = new ArrayDeque<>();
    }

    public void addMessageToLog(Message message) {
        messageLog.add(message);
    }

    public Iterator<Message> getIterator() {
        return messageLog.iterator();
    }

    public Iterator<Message> getReverseIterator() {
        return messageLog.descendingIterator();
    }
}
