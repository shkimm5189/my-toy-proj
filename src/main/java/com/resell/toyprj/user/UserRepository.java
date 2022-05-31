package com.resell.toyprj.user;

import com.resell.toyprj.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByAccount(String account) {
        return em.createQuery("select u from User u where u.account = :account", User.class)
                .setParameter("account", account)
                .getResultList();
    }

    public void update(Long id, User updateParam) {
        User findUser = findOne(id);
        findUser.setAccount(updateParam.getAccount());
        findUser.setPassword(updateParam.getPassword());
        findUser.setEmail(updateParam.getEmail());
        findUser.setAstatus(updateParam.getAstatus());
        findUser.setPhone(updateParam.getPhone());
        findUser.setUpdatedAt(updateParam.getUpdatedAt());
        findUser.setUpdatedBy(updateParam.getUpdatedBy());
    }

}
