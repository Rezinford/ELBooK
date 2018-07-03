package ua.mk.Ryndin.repository.permission;

import ua.mk.Ryndin.entity.Permission;

import java.util.List;

public interface PermissionRepository {

    Permission create(Permission u);
    Permission ubdate(Permission u);
    int delete(Permission u);
    List<Permission> findAll();
    Permission find(Long id);

}
