package com.newproject.core.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.newproject.core.enums.MatchState;

public record Match(
    Long id, LocalDateTime date, Game game, List<Player> players, MatchState matchState, Player winner, Event event
) {
    public boolean hasNullAttributes(){
        return id == null || date == null || game == null || players.isEmpty() || matchState == null || winner.hasNullAttributes() || event == null;
    }
}