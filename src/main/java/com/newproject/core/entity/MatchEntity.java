package com.newproject.core.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.newproject.core.enums.MatchState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "matches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchEntity {
    
    @Id
    @GeneratedValue
    private Long idMatch;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_game", nullable = false)
    private GameEntity gameEntity;

    @ManyToMany
    @JoinTable(
            name = "match_players",
            joinColumns = { @JoinColumn(name="id_match")},
            inverseJoinColumns = {@JoinColumn(name="id_player")}
    )
    private List<PlayerEntity> players;

    @Enumerated(EnumType.STRING)
    private MatchState matchState;

    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false)
    private EventEntity event;

    @OneToOne
    @JoinColumn(name = "id_winner")
    private PlayerEntity winner;


    
    

}
