package com.newproject.core.mapper.game;

import com.newproject.core.domain.Game;
import com.newproject.core.entity.GameEntity;

public interface GameMapper {
    Game toDomain(GameEntity entity);
    GameEntity toEntity(Game domain);
}
