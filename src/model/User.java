package model;

import java.time.Instant;
import java.util.Objects;

public class User {

    private final String userName;

    public User() {
        this.userName = getRandomUserName();
    }

    private String getRandomUserName(){
        return "" + Instant.now().getEpochSecond();
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "User " + userName;
    }
}
