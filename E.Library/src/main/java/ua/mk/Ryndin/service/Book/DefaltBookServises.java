package ua.mk.Ryndin.service.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.book.BookRepository;
import ua.mk.Ryndin.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltBookServises implements BookServises {
    private final BookRepository bookRepository;

    @Autowired
    public DefaltBookServises(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book u) {
        return bookRepository.create(u);
    }

    @Override
    public Book ubdate(Book u) {
        return bookRepository.ubdate(u);
    }

    @Override
    public int delete(Book u) {
        return bookRepository.delete(u);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book find(Long id) {
        return bookRepository.find(id);
    }
}
