package miracle.workWithSql.service.impl;

import miracle.workWithSql.dao.RoleDao;
import miracle.workWithSql.dao.impl.RoleDaoImpl;
import miracle.workWithSql.model.Role;
import miracle.workWithSql.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getAllRoles() {
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.getAllRoles();
    }

    @Override
    public void save(Role role) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.save(role);
    }

    @Override
    public void delete(int id) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.delete(id);
    }

    @Override
    public void update(int id, String name) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.update(id, name);
    }
}
