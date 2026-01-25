package com.newproject.core.service.game;

import com.newproject.core.domain.Game;
import com.newproject.core.entity.GameEntity;
import com.newproject.core.exception.BadRequestException;
import com.newproject.core.mapper.game.GameMapper;
import com.newproject.core.repo.GameRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    private BadRequestException nonExistingGame(){
        return new BadRequestException("Game Not Found in Database");
    }


    @Override
    public void saveGame(@NonNull Game game) {
        gameRepository.save(gameMapper.toEntity(game));
    }

    @Override
    public Optional<Game> getGame(@NonNull Long id) {
        return gameRepository.findById(id).map(gameMapper::toDomain);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDomain)
                .toList();
    }

    @Override
    public void updateGame(@NonNull Game game) {
        if(game.hasNullAttributes()){
            throw new BadRequestException("Event Has Null Attributes, Can't Be Updated");
        }

        GameEntity entity = gameRepository.findById(game.id())
                .orElseThrow(this::nonExistingGame);

        entity.setName(game.name());
        entity.setPrice(game.price());
        entity.setMinPlayers(game.minPlayers());
        entity.setMaxPlayers(game.maxPlayers());
        entity.setDurationMin(game.durationMin());

        gameRepository.save(entity);
    }

    @Override
    public void modifyGame(@NonNull Game game) {
        if (game.id() == null){
            throw new BadRequestException("Game Must Have An Id To Allow Modify");
        }
        GameEntity entity = gameRepository.findById(game.id())
                .orElseThrow(this::nonExistingGame);

        if(!game.name().isBlank()){
            entity.setName(game.name());
        }

        if(game.durationMin() != null){
            entity.setDurationMin(game.durationMin());
        }

        if(game.minPlayers() != null){
            entity.setMinPlayers(game.minPlayers());
        }

        if(game.maxPlayers() != null){
            entity.setMaxPlayers(game.maxPlayers());
        }

        if(game.price() != null){
            entity.setPrice(game.price());
        }

        gameRepository.save(entity);

    }

    @Override
    @Transactional
    public void deleteGame(@NonNull Long id) {
        if(!gameRepository.existsById(id)){
            throw new BadRequestException("Game " + id + " Does not Exist Already");
        }
        gameRepository.deleteById(id);
    }
}
