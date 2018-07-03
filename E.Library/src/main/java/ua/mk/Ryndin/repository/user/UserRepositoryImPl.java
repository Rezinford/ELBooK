package ua.mk.Ryndin.repository.user;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImPl implements UserRepository {

    @PersistenceContext
    public EntityManager user_em;


    public User create(User u) {
        System.out.println("user for create " + u);
        System.out.println("em = " + user_em);
        User bookFromDB = user_em.merge(u);

        return bookFromDB;
    }

    public User ubdate(User u) {
//        user_em.getTransaction().begin();
        User bookFromDB = user_em.merge(u);
//        user_em.getTransaction().commit();
        return bookFromDB;
    }

    public int delete(User u) {
//        user_em.getTransaction().begin();
        user_em.remove(u);
//        user_em.getTransaction().commit();
        return 0;
    }

    public List<User> findAll() {
        TypedQuery<User> namedQuery = user_em.createQuery("SELECT u FROM User_client u", User.class);
//        TypedQuery<Book> namedQuery = user_em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public User find(Long id) {
        return user_em.find(User.class, id);
    }

}
