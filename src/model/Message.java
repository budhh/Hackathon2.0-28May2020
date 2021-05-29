package model;


import java.time.Instant;
import java.util.Objects;

public class Message {

    private final String message;
    private final User user;
    private final Instant instant;

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
        this.instant = Instant.now();
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user.copy();
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return message.equals(message1.message) &&
                user.equals(message1.user) &&
                instant.equals(message1.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, user, instant);
    }

    @Override
    public String toString() {
        String output = "";
        output +=       this.user    + " sent ";
        output += "{" + this.message + "} at ";
        output += "{" + this.instant + "}";
        return  output;
    }
}
