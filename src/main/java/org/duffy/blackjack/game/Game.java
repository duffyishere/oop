package org.duffy.blackjack.game;

import org.duffy.blackjack.deck.Deck;
import org.duffy.blackjack.player.Player;
import org.duffy.blackjack.card.Card;

import java.util.List;

public abstract class Game {

    private int round = 1;

    // Index 0부터 시작
    private int nowPlayerIndex = 0;
    private Player nowPlayer;
    private Deck<? extends Card> deck;
    private List<? extends Player> players;

    public Game(Deck deck, List<? extends Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public Game(Deck deck) {
        this.deck = deck;
    }

    public abstract Card drawingCard();

    public boolean compare(Card to, Card from) {
        return to.getValue() > from.getValue();
    }


    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Player getNowPlayer() {
        return nowPlayer;
    }

    public Deck<? extends Card> getDeck() {
        return deck;
    }

    public void setDeck(Deck<? extends Card> deck) {
        this.deck = deck;
    }

    public List<? extends Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<? extends Player> players) {
        this.players = players;
    }

    public int getNowPlayerIndex() {
        return nowPlayerIndex;
    }

    public void setNowPlayerIndex(int nowPlayerIndex) {
        this.nowPlayerIndex = nowPlayerIndex;
    }

    public void setNowPlayer(Player nowPlayer) {
        this.nowPlayer = nowPlayer;
    }
}
