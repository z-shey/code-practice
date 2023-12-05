package dao.api;

import vo.User;

import java.util.List;

public interface IUserDao {
    User getUserByName(String username);
    User getUser(String username, String password);
    int getUserIdentity(String username);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);

    boolean haveUser(String username, String password);
}
