package ua.mk.Ryndin.repository.publisher;

import ua.mk.Ryndin.entity.Publisher;

import java.util.List;

public interface PublisherRepository {

    Publisher create(Publisher u);
    Publisher ubdate(Publisher u);
    int delete(Publisher u);
    List<Publisher> findAll();
    Publisher find(Long id);

}
