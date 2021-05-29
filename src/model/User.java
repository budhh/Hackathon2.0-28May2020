package model;

import java.util.Objects;

public class User {

    private final String userName;

    User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public User copy() {
        return (new User(this.userName));
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
        return "User {" + userName + "}";
    }
}
