package com.newproject.core.domain;

public record Player(
    Long id, String name, String email, Byte level
) {
    public boolean hasNullAttributes(){
        return id == null || name.isBlank() || email.isBlank() || level == null;
    }
}
