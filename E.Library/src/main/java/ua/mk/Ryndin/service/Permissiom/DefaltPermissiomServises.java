package ua.mk.Ryndin.service.Permissiom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.permission.PermissionRepository;
import ua.mk.Ryndin.entity.Permission;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltPermissiomServises implements PermissiomServises{
    private final PermissionRepository permissionRepository;
@Autowired
    public DefaltPermissiomServises(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission create(Permission u) {
        return permissionRepository.create(u);
    }

    @Override
    public Permission ubdate(Permission u) {
        return permissionRepository.create(u);
    }

    @Override
    public int delete(Permission u) {
        return permissionRepository.delete(u);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission find(Long id) {
        return permissionRepository.find(id);
    }
}
