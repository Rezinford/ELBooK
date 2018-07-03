package ua.mk.Ryndin.repository.publisher;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherRepositoryImPl implements PublisherRepository {
    @PersistenceContext
    public EntityManager publish_em;
   // private Book id;


    public Publisher create(Publisher u) {

        Publisher bookFromDB = publish_em.merge(u);

        return bookFromDB;
    }

    public Publisher ubdate(Publisher u) {

        Publisher bookFromDB = publish_em.merge(u);
//        publish_em.getTransaction().commit();
        return bookFromDB;
    }

    public int delete(Publisher u) {

        publish_em.remove(u);

        return 0;
    }

    public List<Publisher> findAll() {
        TypedQuery<Publisher> namedQuery = publish_em.createQuery("SELECT u FROM Publisher u",Publisher.class  );
//        TypedQuery<Book> namedQuery = publish_em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public Publisher find(Long id) {
        return publish_em.find(Publisher.class, id);
    }

}
