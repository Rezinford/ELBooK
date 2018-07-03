package ua.mk.Ryndin.repository.user;

import ua.mk.Ryndin.entity.User;

import java.util.List;

public interface UserRepository {

    User create(User u);
    User ubdate(User u);
    int delete(User u);
    List<User> findAll();
    User find(Long id);

}
