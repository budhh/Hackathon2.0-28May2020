package model;

import java.util.HashMap;

public class MessageLog {

    HashMap<User, Message> messageLog;

    MessageLog(HashMap log) {
        this.messageLog = log;
    }
}
