package ua.mk.Ryndin.service.Role;

import ua.mk.Ryndin.entity.Role;

import java.util.List;

public interface RoleServises {


    Role create(Role u);
    Role ubdate(Role u);
    int delete(Role u);
    List<Role> findAll();
    Role find(Long id);

}