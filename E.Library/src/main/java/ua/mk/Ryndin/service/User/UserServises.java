package ua.mk.Ryndin.service.User;

import ua.mk.Ryndin.entity.User;

import java.util.List;

public interface UserServises {
    User create(User u);
    User ubdate(User u);
    int delete(User u);
    List<User> findAll();
    User find(Long id);

}
