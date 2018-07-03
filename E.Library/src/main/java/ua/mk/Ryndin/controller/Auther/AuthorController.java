package ua.mk.Ryndin.controller.Auther;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.Ryndin.controller.Auther.Create.AuthorCreateRequest;
import ua.mk.Ryndin.entity.Author;
import ua.mk.Ryndin.service.Author.AuthorServises;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {
    private final AuthorServises authorServises;

    @Autowired
    public AuthorController(AuthorServises authorServises) {
        this.authorServises = authorServises;
    }

    @RequestMapping(path = "/get/(autorID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long autorID, Model model) {

        Author author = authorServises.find(autorID);
        model.addAttribute("index", author);

        return ResponseEntity.ok(authorServises.find(autorID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllAutors() {

        return ResponseEntity.ok(authorServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createUser(ModelAndView modelAndView,
                                     @ModelAttribute(name = "author") AuthorCreateRequest author,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {
        Author auther_1 = new Author();
        auther_1.setAuthorfirstName(author.getAuthorfirstName());
        auther_1.setAuthorlastName(author.getAuthorlastName());
        auther_1.setAuthorstartYear(author.getAuthorstartYear());
        auther_1.setAuthorendYear(author.getAuthorendYear());
        auther_1.setAuthordescription(author.getAuthordescription());
        authorServises.create(auther_1);
        System.out.println(auther_1);
        return ResponseEntity.ok("Author created" + author.toString()); //+ Author.getFirstName()

    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Author author) {
        authorServises.ubdate(author);
        return ResponseEntity.ok("Author updated");
    }

    @RequestMapping(path = "/delete/(autorID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "autorID") Long authorID) {
        Author a = authorServises.find(authorID);
        authorServises.remove(a);
        return ResponseEntity.ok("Author deleted");
    }
}
