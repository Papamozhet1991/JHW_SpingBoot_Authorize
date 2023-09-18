package JHW_Authorization.askovorodko.model;

import java.util.Objects;

public class User {
    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return Objects.equals(user, users.user) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}