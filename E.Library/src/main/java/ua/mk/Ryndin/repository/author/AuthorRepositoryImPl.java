package ua.mk.Ryndin.repository.author;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryImPl implements AuthorRepository {
    @PersistenceContext
    public EntityManager autor_em;// private Book id;


    public Author create(Author u) {

        Author authorFromDB = autor_em.merge(u);

        return authorFromDB;
    }

    public Author ubdate(Author u) {

        Author authorFromDB = autor_em.merge(u);

        return authorFromDB;
    }

    public Long delete(Author u) {

        autor_em.remove(u);

        return 0L;
    }

    public List<Author> findAll() {
        TypedQuery<Author> namedQuery = autor_em.createQuery("SELECT u FROM Author u",Author.class  );
//        TypedQuery<Book> namedQuery = em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public Author find(Long id) {
        return autor_em.find(Author.class, id);
    }

}
