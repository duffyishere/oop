package org.duffy.blackjack.player;

import org.duffy.blackjack.card.Card;
import org.duffy.blackjack.game.Game;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private String name;
    private Game game;
    private List<Card> handedCards = new ArrayList<>();
    private BigDecimal amount;

    public Player(String name, Game game, List<Card> handedCards, BigDecimal amount) {
        this.name = name;
        this.game = game;
        this.handedCards = handedCards;
        this.amount = amount;
    }

    public abstract Card draw();

    public void batting() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Card> getHandedCards() {
        return handedCards;
    }

    public void setHandedCards(List<Card> handedCards) {
        this.handedCards = handedCards;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
