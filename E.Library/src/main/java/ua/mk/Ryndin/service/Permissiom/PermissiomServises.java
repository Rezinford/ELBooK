package ua.mk.Ryndin.service.Permissiom;

import ua.mk.Ryndin.entity.Permission;

import java.util.List;

public interface PermissiomServises {

    Permission create(Permission u);
    Permission ubdate(Permission u);
    int delete(Permission u);
    List<Permission> findAll();
    Permission find(Long id);
}
