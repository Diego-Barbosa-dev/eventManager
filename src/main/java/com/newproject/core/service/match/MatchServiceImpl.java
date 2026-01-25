package com.newproject.core.service.match;

import com.newproject.core.domain.Match;
import com.newproject.core.entity.EventEntity;
import com.newproject.core.entity.MatchEntity;
import com.newproject.core.exception.BadRequestException;
import com.newproject.core.exception.ResourceNotFoundException;
import com.newproject.core.mapper.event.EventMapper;
import com.newproject.core.mapper.game.GameMapper;
import com.newproject.core.mapper.match.MatchMapper;
import com.newproject.core.mapper.player.PlayerMapper;
import com.newproject.core.repo.MatchRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public void saveMatch(@NonNull Match match) {
        matchRepository.save(matchMapper.toEntity(match));
    }

    @Override
    public Optional<Match> getMatch(@NonNull Long id) {
        return matchRepository.findById(id).map(matchMapper::toDomain);
    }

    @Override
    public List<Match> getAllMatch() {
        return matchRepository.findAll()
                .stream().map(matchMapper::toDomain).toList();
    }

    @Override
    public void updateMatch(@NonNull Match match) {
        if(match.hasNullAttributes()){
            throw new BadRequestException("Match Can't Have Null Attributes to Update");
        }
        MatchEntity entity = matchRepository.findById(match.id())
                .orElseThrow(() -> new ResourceNotFoundException("Match Not Found in Database"));

        entity.setDate(match.date());
        entity.setMatchState(match.matchState());
        entity.setGameEntity(gameMapper.toEntity(match.game()));
        entity.setPlayers(match.players().stream().map(playerMapper::toEntity).toList());
        entity.setWinner(playerMapper.toEntity(match.winner()));
        entity.setEvent(eventMapper.toEntity(match.event()));

        matchRepository.save(entity);
    }

    @Override
    public void modifyMatch(Match match) {
        if(match.id() == null){
            throw new BadRequestException("Match without Id Not Allowed To Modify");
        }

        MatchEntity entity = matchRepository.findById(match.id())
                .orElseThrow(() -> new ResourceNotFoundException("Match Does Not Exist"));

        if(match.date() != null){
            entity.setDate(match.date());
        }

        if(match.game() != null){
            entity.setGameEntity(gameMapper.toEntity(match.game()));
        }

        if(match.players() != null){
            entity.setPlayers(match.players().stream().map(playerMapper::toEntity).toList());
        }

        if(match.matchState() != null){
            entity.setMatchState(match.matchState());
        }

        if(match.winner() != null){
            entity.setWinner(playerMapper.toEntity(match.winner()));
        }

        if(match.event() != null){
            entity.setEvent(eventMapper.toEntity(match.event()));
        }

        matchRepository.save(entity);
    }

    @Override
    public void deleteMatch(Match match) {

    }
}
