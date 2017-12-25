package miracle.workWithSql.dao;

import miracle.workWithSql.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();

    void save(Role role);

    void delete(int id);

    void update(Role role);
}
