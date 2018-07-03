package ua.mk.Ryndin.service.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.category.CategoryRepository;
import ua.mk.Ryndin.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltCategoryServises implements CategoryServises{
    private final CategoryRepository categoryRepository;
@Autowired
    public DefaltCategoryServises(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category u) {
        return categoryRepository.create(u);
    }

    @Override
    public Category ubdate(Category u) {
        return categoryRepository.ubdate(u);
    }

    @Override
    public int delete(Category u) {
        return categoryRepository.delete(u);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category find(Long id) {
        return categoryRepository.find(id);
    }
}
