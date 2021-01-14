package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void remove(Long id);
    void edit(User user);
    User getById(Long id);
    User getUserByMail(String mail);
}
