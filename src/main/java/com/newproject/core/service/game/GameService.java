package com.newproject.core.service.game;

import com.newproject.core.domain.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    void saveGame(Game game);
    Optional<Game> getGame(Long id);
    List<Game> getAllGames();
    void updateGame(Game game);
    void modifyGame(Game game);
    void deleteGame(Long id);
}
