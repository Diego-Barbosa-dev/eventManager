package com.newproject.core.mapper.match;

import com.newproject.core.domain.Match;
import com.newproject.core.domain.Player;
import com.newproject.core.entity.MatchEntity;
import com.newproject.core.mapper.event.EventMapper;
import com.newproject.core.mapper.game.GameMapper;
import com.newproject.core.mapper.player.PlayerMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MatchMapperImpl implements MatchMapper{

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public Match toDomain(@NonNull MatchEntity entity) {
        return new Match(
                entity.getIdMatch(),
                entity.getDate(),
                gameMapper.toDomain(entity.getGameEntity()),
                entity.getPlayers().stream().map(playerMapper::toDomain).toList(),
                entity.getMatchState(),
                playerMapper.toDomain(entity.getWinner()),
                eventMapper.toDomain(entity.getEvent())

        );
    }

    @Override
    public MatchEntity toEntity(@NonNull Match domain) {

        return new MatchEntity(
                        domain.id(),
                        domain.date(),
                        gameMapper.toEntity(domain.game()),
                        domain.players().stream().map(playerMapper::toEntity).toList(),
                        domain.matchState(),
                eventMapper.toEntity(domain.event()),
                playerMapper.toEntity(domain.winner())
                );
    }

}
