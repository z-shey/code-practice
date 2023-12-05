package servlet;

public class User {  // 定义User类
    public String id;  // 用户ID
    public String username;  // 用户名
    public String password;  // 密码
    public String identity;  // 值

    public User() {
    }

    public User(String id, String username, String password, String identity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}