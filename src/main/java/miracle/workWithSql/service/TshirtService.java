package miracle.workWithSql.service;

import miracle.workWithSql.model.TShirts;

import java.util.List;

public interface TshirtService {

    List<TShirts> getAllTshirts();

    void save(TShirts t_shirts);

    void delete(int id);

    void update(int id, String color, String size);
}
