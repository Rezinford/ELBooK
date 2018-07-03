package ua.mk.Ryndin.controller.Category;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.Ryndin.service.Category.CategoryServises;
import ua.mk.Ryndin.controller.Category.Create.CategoryCreateRequest;
import ua.mk.Ryndin.entity.Category;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryServises categoryServises;

    @Autowired
    public CategoryController(CategoryServises categoryServises) {
        this.categoryServises = categoryServises;
    }

    @RequestMapping(path = "/get/(catID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long catID, Model model) {

        Category cat = categoryServises.find(catID);
        model.addAttribute("index", cat);

        return ResponseEntity.ok(categoryServises.find(catID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllCategorys() {
        return ResponseEntity.ok(categoryServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
//    public ResponseEntity createCategory(@RequestBody Category category) {
//        categoryServises.create(category);
    public ResponseEntity createCategorys(ModelAndView modelAndView,
                                          @ModelAttribute("category") CategoryCreateRequest category,
                                          BindingResult bindingResult,
                                          HttpServletRequest request) {
        Category category_1 = new Category();
        category_1.setName(category.getCategoryName());
        category_1.setDescription(category.getCategorydescription());
        categoryServises.create(category_1);
        System.out.println(category);
        return ResponseEntity.ok("Category created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Category category) {
        categoryServises.ubdate(category);

        return ResponseEntity.ok("Category updated");
    }

    @RequestMapping(path = "/delete/(catID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "catID") Long catID) {
        Category category_1 = categoryServises.find(catID);
        categoryServises.delete(category_1);
        return ResponseEntity.ok("Category deleted");
    }
}
