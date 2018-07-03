package ua.mk.Ryndin.repository.book;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImPl implements BookRepository {
    @PersistenceContext
    private EntityManager book_em;
   // private Book id;


    public Book create(Book u) {

        Book bookFromDB = book_em.merge(u);

        return bookFromDB;
    }

    public Book ubdate(Book u) {

        Book bookFromDB = book_em.merge(u);

        return bookFromDB;
    }

    public int delete(Book u) {

        book_em.remove(u);

        return 0;
    }

    public List<Book> findAll() {
        TypedQuery<Book> namedQuery = book_em.createQuery("SELECT u FROM Book u",Book.class  );
//        TypedQuery<Book> namedQuery = book_em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public Book find(Long id) {
        return book_em.find(Book.class, id);
    }

}
