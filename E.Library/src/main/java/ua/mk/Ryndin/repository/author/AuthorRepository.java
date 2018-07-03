package ua.mk.Ryndin.repository.author;

import ua.mk.Ryndin.entity.Author;

import java.util.List;

public interface AuthorRepository {

    Author create(Author u);
    Author ubdate(Author u);
    Long delete(Author u);
    List<Author> findAll();
    Author find(Long id);

}
