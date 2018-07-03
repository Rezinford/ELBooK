package ua.mk.Ryndin.controller.Publisher;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.Ryndin.service.Publisher.PublisherServises;
import ua.mk.Ryndin.controller.Publisher.Create.PublisherCreateRequest;
import ua.mk.Ryndin.entity.Publisher;

@Controller
@RequestMapping(path= "/publisher")
public class PublisherController {
    private final PublisherServises publisherServises;
@Autowired
    public PublisherController(PublisherServises publisherServises) {
        this.publisherServises = publisherServises;
    }

    @RequestMapping(path = "/get/(publisherID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long publisherID, Model model) {

        Publisher pub = publisherServises.find(publisherID);
        model.addAttribute("index", pub);


        return ResponseEntity.ok(publisherServises.find(publisherID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllPublishers(){

        return ResponseEntity.ok(publisherServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
                public ResponseEntity createUser(ModelAndView modelAndView,
                                     @ModelAttribute("publisher") PublisherCreateRequest publisher,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {
        Publisher publisher_1= new Publisher();
        publisher_1.setName(publisher.getPublisherName());
        publisher_1.setCountry(publisher.getCountry());
        publisher_1.setDescription(publisher.getPublisherdescription());
        System.out.println(publisher);
        publisherServises.create(publisher_1);
        return ResponseEntity.ok("Publisher created");
    }

//    @RequestMapping(path = "/create", method = RequestMethod.POST)
//    public ResponseEntity createUser(ModelAndView modelAndView,
//                                     @ModelAttribute("autor") AuthorCreateRequest autor,
//                                     BindingResult bindingResult,
//                                     HttpServletRequest request) {
//        Autor autor_1= new Autor();
//        autor_1.setFirstName(autor.getAutorfirstName());
//        autor_1.setLastName(autor.getAutorlastName());
//        autor_1.setStartYear(autor.getAutorstartYear());
//        autor_1.setEndYear(autor.getAutorendYear());
//        autor_1.setDescription(autor.getAutordescription());
//        Autor Autor = autorServises.create(autor_1);
//        System.out.println(autor);
//
//        return ResponseEntity.ok("Autor created" + " " ); //+ autor.getFirstName()
//
//    }
//


    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Publisher publisher) {
        publisherServises.ubdate(publisher);
        return ResponseEntity.ok("Publisher updated");
    }

    @RequestMapping(path = "/delete/(publisherID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "publisherID") Long publisherID){
        Publisher publisher_1=publisherServises.find(publisherID);
        publisherServises.delete(publisher_1);
        return ResponseEntity.ok("Publisher deleted");
    }
}
