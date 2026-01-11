package com.newproject.core.mapper.game;

import com.newproject.core.domain.Game;
import com.newproject.core.entity.GameEntity;
import com.newproject.core.exception.BadRequestException;
import lombok.NonNull;

public class GameMapperImpl implements GameMapper{
    @Override
    public Game toDomain(@NonNull GameEntity entity) {

        return new Game(
                entity.getIdGame(),
                entity.getName(),
                entity.getDurationMin(),
                entity.getMinPlayers(),
                entity.getMaxPlayers(),
                entity.getPrice()
        );
    }

    @Override
    public GameEntity toEntity(@NonNull Game domain) {

        return new GameEntity(
                domain.id(),
                domain.name(),
                domain.durationMin(),
                domain.minPlayers(),
                domain.maxPlayers(),
                domain.price()
        );
    }
}
