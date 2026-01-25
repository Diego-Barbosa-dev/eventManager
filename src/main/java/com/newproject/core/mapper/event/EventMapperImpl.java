package com.newproject.core.mapper.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;
import com.newproject.core.mapper.match.MatchMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapperImpl implements EventMapper{


    @Override
    public Event toDomain(@NonNull EventEntity entity) {
        return new Event(
                entity.getIdEvent(),
                entity.getName(),
                entity.getDate()
        );
    }

    @Override
    public EventEntity toEntity(@NonNull Event domain) {

        return new EventEntity(
                domain.id(),
                domain.name(),
                domain.date()
        );
    }


}
