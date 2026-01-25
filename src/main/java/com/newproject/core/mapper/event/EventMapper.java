package com.newproject.core.mapper.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;
import org.springframework.stereotype.Component;


public interface EventMapper {
    Event toDomain(EventEntity entity);
    EventEntity toEntity(Event domain);
}
