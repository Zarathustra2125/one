package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("userDAO")
public class UserDaoImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        entityManager.remove(getById(id));
    }

    @Transactional
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    @SuppressWarnings("uncheckrd")
    public List<User> allUsers() {
        return entityManager.createQuery("select user From User user").getResultList();
    }

    @Transactional
    @Override
    public User getUserByMail(String mail) {
        return (User) entityManager.createQuery("select user from User user where user.mail=:mail")
                .setParameter("mail", mail)
                .getSingleResult();
    }

}

