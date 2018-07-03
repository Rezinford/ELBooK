package ua.mk.Ryndin.service.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.Ryndin.repository.publisher.PublisherRepository;
import ua.mk.Ryndin.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaltPublisherServises implements PublisherServises{
    private final PublisherRepository publisherRepository;
@Autowired
    public DefaltPublisherServises(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher create(Publisher u) {
        return publisherRepository.create(u);
    }

    @Override
    public Publisher ubdate(Publisher u) {
        return publisherRepository.ubdate(u);
    }

    @Override
    public int delete(Publisher u) {
        return publisherRepository.delete(u);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher find(Long id) {
        return publisherRepository.find(id);
    }
}
