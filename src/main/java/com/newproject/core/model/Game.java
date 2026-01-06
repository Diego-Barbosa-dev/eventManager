package com.newproject.core.model;

public record Game(
    Long id, String name, Long durationMin, Byte minPlayers, Byte maxPlayers, Integer price
) {
    
}
