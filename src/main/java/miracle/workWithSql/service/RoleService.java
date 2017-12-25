package miracle.workWithSql.service;

import miracle.workWithSql.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    void save(Role role);

    void delete(int id);

    void update(int id, String name);
}
