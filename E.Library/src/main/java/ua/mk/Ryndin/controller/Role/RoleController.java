package ua.mk.Ryndin.controller.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.mk.Ryndin.service.Role.RoleServises;
import ua.mk.Ryndin.entity.Role;

@Controller
@RequestMapping(path= "/role")
public class RoleController {
    private final RoleServises roleServises;
@Autowired
    public RoleController(RoleServises roleServises) {
        this.roleServises = roleServises;
    }

    @RequestMapping(path = "/get/(roleID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long roleID){

    return ResponseEntity.ok(roleServises.find(roleID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllRoles(){
        return ResponseEntity.ok(roleServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createRole(@RequestBody Role role) {
        roleServises.create(role);
        return ResponseEntity.ok("Role created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Role role) {
        roleServises.ubdate(role);
        return ResponseEntity.ok("Role updated");
    }

    @RequestMapping(path = "/delete/(roleID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "roleID") Long roleID){
        Role role_1 =  roleServises.find(roleID);
        roleServises.delete(role_1);
        return ResponseEntity.ok("Role deleted");
    }
}
