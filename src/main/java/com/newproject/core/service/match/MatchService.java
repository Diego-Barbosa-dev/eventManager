package com.newproject.core.service.match;


import com.newproject.core.domain.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    void saveMatch(Match match);
    Optional<Match> getMatch(Long id);
    List<Match> getAllMatch();
    void updateMatch(Match match);
    void modifyMatch(Match match);
    void deleteMatch(Match match);
}
