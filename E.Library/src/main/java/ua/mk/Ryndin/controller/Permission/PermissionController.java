package ua.mk.Ryndin.controller.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.mk.Ryndin.service.Permissiom.PermissiomServises;
import ua.mk.Ryndin.entity.Permission;

@Controller
@RequestMapping(path = "/permission")
public class PermissionController {
    private final PermissiomServises permissiomServises;

    @Autowired
    public PermissionController(PermissiomServises permissiomServises) {
        this.permissiomServises = permissiomServises;
    }

    @RequestMapping(path = "/get/(permissionID)", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long permissionID) {

        return ResponseEntity.ok(permissiomServises.find(permissionID));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllPermissions() {
        return ResponseEntity.ok(permissiomServises.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createPermission(@RequestBody Permission permission) {
        permissiomServises.create(permission);
        return ResponseEntity.ok("Permission created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Permission permission) {
        permissiomServises.ubdate(permission);
        return ResponseEntity.ok("Permission updated");
    }

    @RequestMapping(path = "/delete/(permissionID)", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "permissionID") Long permissionID) {
        Permission permission_z1 = permissiomServises.find(permissionID);
        permissiomServises.delete(permission_z1);
        return ResponseEntity.ok("Permission deleted");
    }
}
