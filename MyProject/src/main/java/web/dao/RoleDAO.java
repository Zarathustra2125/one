package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import java.util.Set;

@Repository
public interface RoleDAO {
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
