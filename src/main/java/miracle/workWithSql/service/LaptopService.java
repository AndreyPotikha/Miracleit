package miracle.workWithSql.service;

import miracle.workWithSql.model.Laptop;

import java.util.List;

public interface LaptopService {

    List<Laptop> getAllUsers();

    void save(Laptop laptop);

    void delete(int id);

    void update(int id, String name, int userId);
}
