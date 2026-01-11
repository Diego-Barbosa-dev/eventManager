package com.newproject.core.mapper.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;

public interface EventMapper {
    Event toDomain(EventEntity entity);
    EventEntity toEntity(Event domain);
}
