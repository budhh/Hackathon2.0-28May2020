package model;

import java.util.Objects;

public class User {

    private final String client;

    User(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public User copy() {
        return (new User(this.client));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return client.equals(user.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }


    @Override
    public String toString() {
        return "User{" +
                "client='" + client + '\'' +
                '}';
    }
}
