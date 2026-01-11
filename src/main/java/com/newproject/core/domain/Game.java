package com.newproject.core.domain;

public record Game(
    Long id, String name, Long durationMin, Byte minPlayers, Byte maxPlayers, Integer price
) {
    public boolean hasNullAttributes(){
        return id == null || name.isBlank() || durationMin == null
                || minPlayers == null || maxPlayers == null || price == null;
    }
}
