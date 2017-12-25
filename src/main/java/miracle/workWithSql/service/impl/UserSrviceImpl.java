package miracle.workWithSql.service.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.UserDao;
import miracle.workWithSql.dao.impl.UserDaoImpl;
import miracle.workWithSql.model.User;
import miracle.workWithSql.service.UserService;

import java.util.List;

public class UserSrviceImpl implements UserService{

    private static final String INSERT_USER = "INSERT INTO miracle.users (name, skills) VALUES (?,?)";

    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAllUsers();
    }


    @Override
    public void save(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
        UserDao userDao = new UserDaoImpl();
        userDao.delete(id);
    }

    @Override
    public void updateUserName(int idUser, String newName) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUserName(idUser, newName);
    }

    @Override
    public void updateUserSkills(int idUser, String newSkills) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUserSkills(idUser, newSkills);
    }

    @Override
    public void updateUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUser(user);
    }
}
