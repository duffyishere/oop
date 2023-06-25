package org.duffy.cardGame;

import java.util.List;

public abstract class Deck {
    private List<Card> cards;

    public abstract void shuffle();
    public abstract Card draw();
}
