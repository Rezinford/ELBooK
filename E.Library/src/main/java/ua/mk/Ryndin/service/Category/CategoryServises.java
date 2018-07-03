package ua.mk.Ryndin.service.Category;

import ua.mk.Ryndin.entity.Category;

import java.util.List;

public interface CategoryServises {
    Category create(Category u);
    Category ubdate(Category u);
    int delete(Category u);
    List<Category> findAll();
    Category find(Long id);

}
