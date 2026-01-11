package com.newproject.core.mapper.event;

import com.newproject.core.domain.Event;
import com.newproject.core.entity.EventEntity;
import com.newproject.core.exception.BadRequestException;
import com.newproject.core.mapper.match.MatchMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class EventMapperImpl implements EventMapper{

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public Event toDomain(@NonNull EventEntity entity) {
        return new Event(
                entity.getIdEvent(),
                entity.getName(),
                entity.getDate(),
                entity.getMatches().stream().map(matchMapper::toDomain).toList()
        );
    }

    @Override
    public EventEntity toEntity(@NonNull Event domain) {

        return new EventEntity(
                domain.id(),
                domain.name(),
                domain.date(),
                domain.matches().stream().map(matchMapper::toEntity).toList()
        );
    }
}
