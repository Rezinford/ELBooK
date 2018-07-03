package ua.mk.Ryndin.service.Author;

import ua.mk.Ryndin.entity.Author;

import java.util.List;

public interface AuthorServises {
    Author create(Author u);
    Author ubdate(Author u);
    Long remove(Author u);
    List<Author> findAll();
    Author find(Long id);

}
