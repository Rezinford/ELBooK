package ua.mk.Ryndin.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.user.UserRepository;
import ua.mk.Ryndin.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltUserServises implements UserServises{
    private final UserRepository userRepository;
@Autowired
    public DefaltUserServises(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User u) {
        return userRepository.create(u);
    }

    @Override
    public User ubdate(User u) {
        return userRepository.ubdate(u);
    }

    @Override
    public int delete(User u) {
        return userRepository.delete(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User find(Long id) {
        return userRepository.find(id);
    }
}
