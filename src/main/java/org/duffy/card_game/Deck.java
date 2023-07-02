package org.duffy.card_game;

import java.util.List;

public abstract class Deck {
    private List<Card> cards;

    public abstract void shuffle();
    public abstract Card draw();
}
