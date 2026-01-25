package com.newproject.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Event(
    Long id,
    String name,
    LocalDateTime date
) {
    public boolean hasNullAttributes(){
        return id == null || name.isBlank() || date == null;
    }
}
