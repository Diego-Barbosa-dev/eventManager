package com.newproject.core.service.event;

import com.newproject.core.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    void saveEvent(Event event);
    Optional<Event> getEvent(Long id);
    List<Event> getAllEvents();
    void updateEvent(Event event);
    void modifyEvent(Event event);
    void deleteEvent(Long id);
}
