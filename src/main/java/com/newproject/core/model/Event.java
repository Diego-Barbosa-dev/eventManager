package com.newproject.core.model;

import java.time.LocalDateTime;
import java.util.List;

public record Event(
    Long id,
    String name,
    LocalDateTime date,
    List<Match> matches
) {}
