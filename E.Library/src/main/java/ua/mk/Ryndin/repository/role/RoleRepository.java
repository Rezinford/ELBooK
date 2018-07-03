package ua.mk.Ryndin.repository.role;

import ua.mk.Ryndin.entity.Role;

import java.util.List;

public interface RoleRepository {

    Role create(Role u);
    Role ubdate(Role u);
    int delete(Role u);
    List<Role> findAll();
    Role find(Long id);

}
