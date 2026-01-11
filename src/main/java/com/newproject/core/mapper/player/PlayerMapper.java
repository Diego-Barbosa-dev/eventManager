package com.newproject.core.mapper.player;

import com.newproject.core.domain.Player;
import com.newproject.core.entity.PlayerEntity;

public interface PlayerMapper {
    Player toDomain(PlayerEntity entity);
    PlayerEntity toEntity(Player domain);
}
