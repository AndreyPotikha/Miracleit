package miracle.workWithSql.dao;

import miracle.workWithSql.model.Laptop;

import java.util.List;

public interface LaptopsDao {

    List<Laptop> getAll();

    void save(Laptop laptop);

    void delete(int id);

    void update(int id, String name, int userId);
}
