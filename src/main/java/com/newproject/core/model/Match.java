package com.newproject.core.model;

import java.time.LocalDateTime;
import java.util.List;

import com.newproject.core.enums.MatchState;

public record Match(
    Long id, LocalDateTime date, Game game, List<Player> players, MatchState matchState, Player winner
) {
    
}