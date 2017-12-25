package miracle.workWithSql.dao.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.UserRoleDao;
import miracle.workWithSql.model.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {

    private static final String GET_ALL_ROLLES = "SELECT * FROM user_role";
    private static final String SAVE_NEW_ROLES = "INSERT INTO user_role (user_id, role_id) VALUES (5,6)";

    @Override
    public List<UserRole> getAllUsers() {
        List<UserRole> userRoles = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(GET_ALL_ROLLES);

            while (resultSet.next()) {
                UserRole userRole = new UserRole();
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                int role_id = resultSet.getInt("role_id");
                userRole.setId(id);
                userRole.setUserId(user_id);
                userRole.setRoleId(role_id);
                userRoles.add(userRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public void save(UserRole userRole) {

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SAVE_NEW_ROLES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
