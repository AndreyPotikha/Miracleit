package miracle.workWithSql.dao;

import miracle.workWithSql.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void save(User user);

    void delete(int idUsers);

    void updateUserName(int idUser, String newName);

    void updateUserSkills(int idUser, String newSkills);

    void updateUser(int idUser, String newName, String newSkills);
}
