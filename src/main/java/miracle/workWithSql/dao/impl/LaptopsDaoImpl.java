package miracle.workWithSql.dao.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.LaptopsDao;
import miracle.workWithSql.model.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopsDaoImpl implements LaptopsDao {

    private static final String GET_ALL_LAPTOPS = "SELECT * FROM laptops";
    private static final String ADD_NEW_LAPTOPS = "INSERT INTO laptops (name, user_id) VALUES (?,?)";
    private static final String DELETE_FROM_LAPTOPS = "DELETE FROM laptops WHERE id = (?)";
    private static final String UPDATE_LAPTOT = "UPDATE laptops SET name = (?), user_id = (?) WHERE id = (?)";

    @Override
    public List<Laptop> getAll() {
        List<Laptop> laptops = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(GET_ALL_LAPTOPS);
            while (resultSet.next()) {
                Laptop laptop = new Laptop();
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int user_id = resultSet.getInt(3);
                laptop.setId(anInt);
                laptop.setName(name);
                laptop.setUserId(user_id);
                laptops.add(laptop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

    @Override
    public void save(Laptop laptop) {

        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_LAPTOPS);
            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setInt(2, laptop.getUserId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_LAPTOPS);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String name, int userId) {
        Connection connection = Database.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LAPTOT);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
