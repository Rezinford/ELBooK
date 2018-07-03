package ua.mk.Ryndin.repository.category;

import org.springframework.stereotype.Repository;
import ua.mk.Ryndin.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImPl implements CategoryRepository {
    @PersistenceContext
    public EntityManager cat_em;
    // private Book id;


    public Category create(Category u) {

        Category bookFromDB = cat_em.merge(u);

        return bookFromDB;
    }

    public Category ubdate(Category u) {

        Category bookFromDB = cat_em.merge(u);

        return bookFromDB;
    }

    public int delete(Category u) {

        cat_em.remove(u);

        return 0;
    }

    public List<Category> findAll() {
        TypedQuery<Category> namedQuery = cat_em.createQuery("SELECT c FROM Category c", Category.class);
//        TypedQuery<Book> namedQuery = em.createQuery("SELECT u FROM Book ",Book.class);
        return namedQuery.getResultList();
    }

    public Category find(Long id) {
        return cat_em.find(Category.class, id);
    }

}
