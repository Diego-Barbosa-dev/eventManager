package com.newproject.core.mapper.player;

import com.newproject.core.domain.Player;
import com.newproject.core.entity.PlayerEntity;
import lombok.NonNull;

public class PlayerMapperImpl implements PlayerMapper{

    @Override
    public Player toDomain(@NonNull PlayerEntity entity) {
        return new Player(
                entity.getIdPlayer(),
                entity.getName(),
                entity.getEmail(),
                entity.getLevel()
        );
    }

    @Override
    public PlayerEntity toEntity(@NonNull Player domain) {
        return new PlayerEntity(
                domain.id(),
                domain.name(),
                domain.email(),
                domain.level()
        );
    }
}
