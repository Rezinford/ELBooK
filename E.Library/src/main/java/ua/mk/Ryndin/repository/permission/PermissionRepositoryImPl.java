package ua.mk.Ryndin.repository.permission;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.Permission;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PermissionRepositoryImPl implements PermissionRepository {
    @PersistenceContext
    public EntityManager permis_em;
   // private Book id;


    public Permission create(Permission u) {
//        permis_em.getTransaction().begin();
        Permission bookFromDB = permis_em.merge(u);
//        permis_em.getTransaction().commit();
        return bookFromDB;
    }

    public Permission ubdate(Permission u) {
//        permis_em.getTransaction().begin();
        Permission bookFromDB = permis_em.merge(u);
//        permis_em.getTransaction().commit();
        return bookFromDB;
    }

    public int delete(Permission u) {
//        permis_em.getTransaction().begin();
        permis_em.remove(u);
//        permis_em.getTransaction().commit();
        return 0;
    }

    public List<Permission> findAll() {
        TypedQuery<Permission> namedQuery = permis_em.createQuery("SELECT u FROM Permission ",Permission.class  );
//        TypedQuery<Book> namedQuery = permis_em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public Permission find(Long id) {
        return permis_em.find(Permission.class, id);
    }

}
