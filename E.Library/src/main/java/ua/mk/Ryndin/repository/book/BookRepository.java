package ua.mk.Ryndin.repository.book;

import ua.mk.Ryndin.entity.Book;

import java.util.List;

public interface BookRepository {

    Book create(Book u);
    Book ubdate(Book u);
    int delete(Book u);
    List<Book> findAll();
    Book find(Long id);

}
