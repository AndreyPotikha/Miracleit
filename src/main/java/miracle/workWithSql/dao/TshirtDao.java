package miracle.workWithSql.dao;

import miracle.workWithSql.model.TShirts;

import java.util.List;

public interface TshirtDao {

    List<TShirts> getAllTshirts();

    void save(TShirts t_shirts);

    void delete(int id);

    void update(TShirts tShirts);
}
