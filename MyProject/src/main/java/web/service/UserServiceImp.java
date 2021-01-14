package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void remove(Long id) {
        userDAO.remove(id);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public User getUserByMail(String mail) {

        return userDAO.getUserByMail(mail);
    }

    @Override
    public void createRole(Set<Role> roles) {
        roleDAO.createRole(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.getUserByMail(s);
    }

}
