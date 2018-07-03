package ua.mk.Ryndin.service.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.author.AuthorRepository;
import ua.mk.Ryndin.entity.Author;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltAuthorServises implements AuthorServises {
    private final AuthorRepository authorRepository;
@Autowired
    public DefaltAuthorServises(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author u) {
        return authorRepository.create(u);
    }

    @Override
    public Author ubdate(Author u) {
        return authorRepository.ubdate(u);
    }

    @Override
    public Long remove(Author u) {
        return authorRepository.delete(u);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author find(Long id) {
        return authorRepository.find(id);
    }
}