package miracle.workWithSql.dao.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.RoleDao;
import miracle.workWithSql.model.Role;

import java.awt.print.PrinterAbortException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{

    private static final String GET_ALL_ROLES = "SELECT * FROM roles";
    private static final String SAVE_NEW_ROLES = "INSERT INTO roles (name) VALUE (?)";
    private static final String DELETE_ROLE = "DELETE FROM roles WHERE id = (?)";
    private static final String UPDAT_ROLE = "UPDATE roles SET name = (?) WHERE id = (?)";

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_ROLES);
            while (resultSet.next()) {
                Role role = new Role();
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString("name");
                role.setId(anInt);
                role.setName(name);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void save(Role role) {
        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_NEW_ROLES);
            preparedStatement.setString(1, role.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROLE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String name) {
        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDAT_ROLE);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
