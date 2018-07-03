package ua.mk.Ryndin.controller.Book;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.Ryndin.service.Author.AuthorServises;
import ua.mk.Ryndin.service.Book.BookServises;
import ua.mk.Ryndin.service.Category.CategoryServises;
import ua.mk.Ryndin.service.Publisher.PublisherServises;
import ua.mk.Ryndin.controller.Book.Create.BookCreateRequest;
import ua.mk.Ryndin.entity.Author;
import ua.mk.Ryndin.entity.Book;
import ua.mk.Ryndin.entity.Category;
import ua.mk.Ryndin.entity.Publisher;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/book")
public class BookController {
    //<============================================================================>
    private final BookServises bookServices;
    private final AuthorServises authorServices;
    private final CategoryServises categoryServises;
    private final PublisherServises publisherServises;
    //<============================================================================>
    @Autowired
    public BookController(BookServises bookServices, AuthorServises authorServices, CategoryServises categoryServises, PublisherServises publisherServises) {
        this.bookServices = bookServices;
        this.authorServices = authorServices;
        this.categoryServises = categoryServises;
        this.publisherServises = publisherServises;
    }
    //<============================================================================>
    @RequestMapping(path = "/get/(bookId)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long bookId) {
        bookServices.find(bookId);
        return ResponseEntity.ok("Get book by id " + bookId);
    }

    //<============================================================================>
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllBooks() {
        bookServices.findAll();
        return ResponseEntity.ok("Get All books"+bookServices.findAll());
    }
    //<============================================================================>
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createBook(ModelAndView modelAndView, @ModelAttribute(name = "book") BookCreateRequest book,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {
        Book book1 = new Book();
        List<Author> authors = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<Publisher> publishers = new ArrayList<>();

        for (Long autorID : book.getBookautherName()) {
            authors.add(authorServices.find(autorID));
        }
        book1.setAutor(authors);

        for (Long catID : book.getBookCategoryName()) {
            categories.add(categoryServises.find(catID));
        }
        book1.setCategory(categories);

        for (Long publisherID : book.getBookPublisherName()) {
            publishers.add(publisherServises.find(publisherID));
        }

        book1.setPublisher(publishers);
        book1.setBookName(book.getBookName());
        book1.setDataPublicData(book.getBookdataPublicData());
        book1.setDescription(book.getBookdescription());
        bookServices.create(book1);
        System.out.println(book);
        return ResponseEntity.ok("Book created");
//        book1.setRang("2fghfdh");
//
//        rang = null;
//        page = null;
//        dataPublicData = null;
//        language = null;
//        autor = null;
//        category = null;
//        ibsn = null;

    }
    //<============================================================================>
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Book book) {
        bookServices.ubdate(book);
        return ResponseEntity.ok("Book updated");
    }
    //<============================================================================>
    @RequestMapping(path = "/delete/(bookId)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "bookId") Long bookId) {
        Book book_1 = bookServices.find(bookId);
        bookServices.delete(book_1);
        return ResponseEntity.ok("Book deleted");
    }
    //<============================================================================>
}
