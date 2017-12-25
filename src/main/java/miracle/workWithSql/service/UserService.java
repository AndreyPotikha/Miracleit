package miracle.workWithSql.service;


import miracle.workWithSql.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void save(User user);

    void delete(int id);

    void updateUserName(int idUser, String newName);

    void updateUserSkills(int idUser, String newSkills);

    void updateUser(int idUser, String newName, String newSkills);


}
