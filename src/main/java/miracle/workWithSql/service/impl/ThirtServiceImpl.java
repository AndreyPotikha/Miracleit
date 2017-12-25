package miracle.workWithSql.service.impl;

import miracle.workWithSql.dao.TshirtDao;
import miracle.workWithSql.dao.impl.TshirtDaoImpl;
import miracle.workWithSql.model.TShirts;
import miracle.workWithSql.service.TshirtService;

import java.util.List;

public class ThirtServiceImpl implements TshirtService {
    @Override
    public List<TShirts> getAllTshirts() {
        TshirtDao tshirtDao = new TshirtDaoImpl();
        return tshirtDao.getAllTshirts();
    }

    @Override
    public void save(TShirts t_shirts) {
        TshirtDao tshirtDao = new TshirtDaoImpl();
        tshirtDao.save(t_shirts);
    }

    @Override
    public void delete(int id) {
        TshirtDao tshirtDao = new TshirtDaoImpl();
        tshirtDao.delete(id);
    }

    @Override
    public void update(TShirts tShirts) {
        TshirtDao tshirtDao = new TshirtDaoImpl();
        tshirtDao.update(tShirts);
    }
}
