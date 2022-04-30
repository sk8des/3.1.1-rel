package com.example.aliquid.web.repository;

import com.example.aliquid.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void newUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("From User ORDER BY id").getResultList();
    }
}
