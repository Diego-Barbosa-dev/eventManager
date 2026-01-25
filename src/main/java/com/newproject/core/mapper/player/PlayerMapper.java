package com.newproject.core.mapper.player;

import com.newproject.core.domain.Player;
import com.newproject.core.entity.PlayerEntity;
import org.springframework.stereotype.Component;


public interface PlayerMapper {
    Player toDomain(PlayerEntity entity);
    PlayerEntity toEntity(Player domain);

}
