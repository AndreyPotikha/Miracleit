package miracle.workWithSql.dao.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.UserDao;
import miracle.workWithSql.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER = "INSERT INTO miracle.users (name, skills) VALUES (?,?)";
    private static final String DELETE_USER = "DELETE FROM miracle.users WHERE id = (?)";
    private static final String UPDATE_USER_NAME = "UPDATE miracle.users SET name = (?) WHERE id = (?)";
    private static final String UPDATE_USER_SKILLS = "UPDATE miracle.users SET skills = (?) WHERE id = (?)";
    private static final String UPDATE_USER = "UPDATE miracle.users SET name = (?), skills = (?) WHERE id = (?)";

    @Override

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM miracle.users");

            while (resultSet.next()) {
                User user = new User();
                String name = resultSet.getString("name");
                String skills = resultSet.getString("skills");
                int anInt = resultSet.getInt(1);
                user.setName(name);
                user.setSkills(skills);
                user.setId(anInt);
                allUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }


    @Override
    public void save(User user) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int idUsers) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
            preparedStatement.setInt(1, idUsers);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUserName(int idUser, String newName) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_NAME)){
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, idUser);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUserSkills(int idUser, String newSkills) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SKILLS)){
            preparedStatement.setString(1, newSkills);
            preparedStatement.setInt(2, idUser);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getSkills());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
