package miracle.workWithSql.dao;

import miracle.workWithSql.model.UserRole;

import java.util.List;

public interface UserRoleDao {

    List<UserRole> getAllUsers();

    void save(UserRole userRole);
}
