package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    List<User> allUsers();
    void add(User user);
    void remove(Long id);
    void edit(User user);
    User getById(Long id);
    User getUserByMail(String mail);
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
