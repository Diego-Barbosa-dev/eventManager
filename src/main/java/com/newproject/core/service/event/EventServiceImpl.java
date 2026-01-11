package com.newproject.core.service.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;
import com.newproject.core.exception.BadRequestException;
import com.newproject.core.mapper.event.EventMapper;
import com.newproject.core.repo.EventRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;


    @Override
    public void saveEvent(@NonNull Event event) {
        eventRepository.save(
            eventMapper.toEntity(event)
        );
    }

    @Override
    public Optional<Event> getEvent(@NonNull Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDomain);
    }

    @Override
    public List<Event> getAllEvents() {

        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDomain)
                .toList();
    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void modifyEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }
}
