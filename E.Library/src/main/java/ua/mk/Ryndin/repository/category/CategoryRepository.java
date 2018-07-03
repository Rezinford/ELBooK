package ua.mk.Ryndin.repository.category;

import ua.mk.Ryndin.entity.Category;

import java.util.List;

public interface CategoryRepository {

    Category create(Category u);
    Category ubdate(Category u);
    int delete(Category u);
    List<Category> findAll();
    Category find(Long id);

}
