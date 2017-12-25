package miracle.workWithSql.dao.impl;

import miracle.workWithSql.config.Database;
import miracle.workWithSql.dao.TshirtDao;
import miracle.workWithSql.model.Laptop;
import miracle.workWithSql.model.TShirts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TshirtDaoImpl implements TshirtDao {

    private static final String GET_ALL_TSHIRTS = "SELECT * FROM `t-shirts`";
    private static final String SAVE_TSHIRTS = "INSERT INTO `t-shirts` (color, size) VALUE (?, ?)";
    private static final String DELETE_TSHIRT = "DELETE FROM `t-shirts` WHERE id = (?);";
    private static final String UPDATE_TSHIRT = "UPDATE `t-shirts` SET color = (?), size = (?) WHERE id = (?)";

    @Override
    public List<TShirts> getAllTshirts() {
        List<TShirts> tShirts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(GET_ALL_TSHIRTS);
            while (resultSet.next()) {
                TShirts tShirts1 = new TShirts();
                int anInt = resultSet.getInt(1);
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                tShirts1.setId(anInt);
                tShirts1.setColor(color);
                tShirts1.setSize(size);
                tShirts.add(tShirts1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tShirts;
    }

    @Override
    public void save(TShirts t_shirts) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_TSHIRTS)){
            preparedStatement.setString(1, t_shirts.getColor());
            preparedStatement.setString(2, t_shirts.getSize());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TSHIRT)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String color, String size) {

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TSHIRT)){
            preparedStatement.setString(1, color);
            preparedStatement.setString(2, size);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
