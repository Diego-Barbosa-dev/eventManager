package com.newproject.core.mapper.match;

import com.newproject.core.domain.Match;
import com.newproject.core.entity.MatchEntity;

public interface MatchMapper {
    Match toDomain(MatchEntity entity);
    MatchEntity toEntity(Match domain);
}
