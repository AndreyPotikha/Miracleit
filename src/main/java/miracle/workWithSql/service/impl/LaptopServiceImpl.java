package miracle.workWithSql.service.impl;

import miracle.workWithSql.dao.LaptopsDao;
import miracle.workWithSql.dao.impl.LaptopsDaoImpl;
import miracle.workWithSql.model.Laptop;
import miracle.workWithSql.service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {

    @Override
    public List<Laptop> getAllUsers() {
        LaptopsDao laptopsDao = new LaptopsDaoImpl();
        List<Laptop> all = laptopsDao.getAll();
        return all;
    }

    @Override
    public void save(Laptop laptop) {
        LaptopsDao laptopsDao = new LaptopsDaoImpl();
        laptopsDao.save(laptop);
    }

    @Override
    public void delete(int id) {
        LaptopsDao laptopsDao = new LaptopsDaoImpl();
        laptopsDao.delete(id);
    }

    @Override
    public void update(int id, String name, int userId) {
        LaptopsDao laptopsDao = new LaptopsDaoImpl();
        laptopsDao.update(id, name, userId);
    }
}
