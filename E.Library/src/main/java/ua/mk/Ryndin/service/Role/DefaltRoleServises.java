package ua.mk.Ryndin.service.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.role.RoleRepository;
import ua.mk.Ryndin.entity.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltRoleServises implements RoleServises {
    private final RoleRepository roleRepository;

    @Autowired
    public DefaltRoleServises(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role u) {
        return roleRepository.create(u);
    }

    @Override
    public Role ubdate(Role u) {
        return roleRepository.ubdate(u);
    }

    @Override
    public int delete(Role u) {
        return roleRepository.delete(u);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role find(Long id) {
        return roleRepository.find(id);
    }
}
