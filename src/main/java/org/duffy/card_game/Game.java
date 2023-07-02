package org.duffy.card_game;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    public ArrayList<Player> players;
    public int nowPlayerIndex = 0;

    public int turnCount = 0;

    public Deck deck;

    public abstract void play(List<Player> players, Deck deck);
    public abstract void endPlaying();

    public Player getNowTurnPlayer() {
        return players.get(nowPlayerIndex);
    };
}
