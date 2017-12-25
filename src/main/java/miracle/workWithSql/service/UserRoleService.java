package miracle.workWithSql.service;

import miracle.workWithSql.model.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getAllUserRole();

    void save(UserRole userRole);
}
