package com.newproject.core.service.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;
import com.newproject.core.exception.BadRequestException;
import com.newproject.core.mapper.event.EventMapper;
import com.newproject.core.repo.EventRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;


    private BadRequestException nonExistingEvent(){
        return new BadRequestException("Event Not Found in Database");
    }

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
    public void updateEvent(@NonNull Event event) {
        if (event.hasNullAttributes()){
            throw new BadRequestException("Event Has Null Attributes, Can't Be Updated");
        }

        EventEntity entity = eventRepository.findById(event.id())
                .orElseThrow(this::nonExistingEvent);

       entity.setName(event.name());
       entity.setDate(event.date());

        eventRepository.save(entity);

    }

    @Override
    public void modifyEvent(@NonNull Event event) {
        if(event.id() == null){
            throw new BadRequestException("Event Must Have An Id To Allow Modify");
        }
        EventEntity entity = eventRepository.findById(event.id())
                .orElseThrow(this::nonExistingEvent);

        if(!event.name().isBlank()){
            entity.setName(event.name());
        }
        if(event.date() != null){
            entity.setDate(event.date());
        }

        eventRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteEvent(@NonNull Long id) {
        if(!eventRepository.existsById(id)){
            throw new BadRequestException("Event " + id + " Does not Exist Already");
        }

        eventRepository.deleteById(id);
    }
}
