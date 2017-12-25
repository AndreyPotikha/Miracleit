package miracle.workWithSql.service.impl;

import miracle.workWithSql.dao.UserRoleDao;
import miracle.workWithSql.dao.impl.UserRoleDaoImpl;
import miracle.workWithSql.model.UserRole;
import miracle.workWithSql.service.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<UserRole> getAllUserRole() {
        UserRoleDao userRoleDao = new UserRoleDaoImpl();
        return userRoleDao.getAllUsers();
    }

    @Override
    public void save(UserRole userRole) {
        UserRoleDao userRoleDao = new UserRoleDaoImpl();
        userRoleDao.save(userRole);
    }
}
