package ua.mk.Ryndin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.mk.Ryndin.controller.Auther.Create.AuthorCreateRequest;
import ua.mk.Ryndin.controller.Book.Create.BookCreateRequest;
import ua.mk.Ryndin.controller.Category.Create.CategoryCreateRequest;
import ua.mk.Ryndin.controller.Publisher.Create.PublisherCreateRequest;
import ua.mk.Ryndin.controller.User.Forms.UserForm;
import ua.mk.Ryndin.service.Author.AuthorServises;
import ua.mk.Ryndin.service.Book.BookServises;
import ua.mk.Ryndin.service.Category.CategoryServises;
import ua.mk.Ryndin.service.Publisher.PublisherServises;

@Controller
public class MainController {
    @Autowired
    private AuthorServises authorServices;
    @Autowired
    private CategoryServises categoryServises;
    @Autowired
    private PublisherServises publisherServises;
    @Autowired
    private BookServises bookServices;

    @GetMapping("/")
    public String root(ModelMap model) {
        model.addAttribute("admin", bookServices.findAll());
        return "index";
    }

    @GetMapping("/login")

    public String login(Model model) {
        model.addAttribute("login", new UserForm());
        return "login";
    }

    @GetMapping("/singin")

    public String Singin(Model model) {
        model.addAttribute("user", new UserForm());
        return "singin";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("author", new AuthorCreateRequest());
        model.addAttribute("book", new BookCreateRequest());
        model.addAttribute("category", new CategoryCreateRequest());
        model.addAttribute("publisher", new PublisherCreateRequest());
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("author", new AuthorCreateRequest());
        model.addAttribute("book", new BookCreateRequest());
        model.addAttribute("category", new CategoryCreateRequest());
        model.addAttribute("publisher", new PublisherCreateRequest());
//
//        System.out.println("a "+ Arrays.toString(authorServices.findAll().toArray()));
//        System.out.println("c "+Arrays.toString(categoryServises.findAll().toArray()));
        model.addAttribute("authors", authorServices.findAll());
        model.addAttribute("categories", categoryServises.findAll());
        model.addAttribute("publishers", publisherServises.findAll());
        return "admin";
    }

}
