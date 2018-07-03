package ua.mk.Ryndin.controller.User;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.Ryndin.entity.Role;
import ua.mk.Ryndin.service.Role.RoleServises;
import ua.mk.Ryndin.service.User.UserServises;
import ua.mk.Ryndin.controller.User.Forms.UserForm;
import ua.mk.Ryndin.controller.User.Requests.CreateUserRequest;
import ua.mk.Ryndin.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserServises userServises;
    private final RoleServises roleServises;


    @Autowired
    public UserController(UserServises userServises, RoleServises roleServises) {
        this.userServises = userServises;
        this.roleServises = roleServises;
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity login(ModelAndView modelAndView, @ModelAttribute(name = "login") UserForm user,
                                BindingResult bindingResult,
                                HttpServletRequest reques){
        User user1 = new User();
        user1.setE_mail(user.getE_mail());
        user1.setPassword(user1.getPassword());
        return ResponseEntity.ok("Login: " + user1.getE_mail());
    }

    @RequestMapping(path = "/get/(userID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long userID) {

        return ResponseEntity.ok(userServises.find(userID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {

        return ResponseEntity.ok(userServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createUser(ModelAndView modelAndView, @ModelAttribute(name = "user") CreateUserRequest user, BindingResult bindingResult, HttpServletRequest request) {
//        userServises.create(user);
        User user_2 = new User();
        user_2.setFirst_name(user.getFirst_name());
        user_2.setLast_namee(user.getLast_name());
        user_2.setE_mail(user.getE_mail());
        user_2.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user_2.setAge(user.getAge());
        List<Role> roles = new ArrayList<>();
        roles.add(roleServises.find(2L));
        user_2.setRole(roles);
        userServises.create(user_2);
        System.out.println(user_2);
        return "redirect:/index";

    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        userServises.ubdate(user);
        return ResponseEntity.ok("User updated");
    }

    @RequestMapping(path = "/delete/(userID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "userID") Long userID) {
        User user_1 = userServises.find(userID);
        userServises.delete(user_1);
        return ResponseEntity.ok("User deleted"+ userID);
    }
}
