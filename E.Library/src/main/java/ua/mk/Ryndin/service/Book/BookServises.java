package ua.mk.Ryndin.service.Book;

import ua.mk.Ryndin.entity.Book;

import java.util.List;

public interface BookServises {
    Book create(Book u);
    Book ubdate(Book u);
    int delete(Book u);
    List<Book> findAll();
    Book find(Long id);

}
