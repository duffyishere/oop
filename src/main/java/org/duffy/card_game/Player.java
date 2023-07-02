package org.duffy.card_game;

import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> holdingCards;

    public abstract void draw();
    public abstract void playCard(int cardIndex);

    public String getName() {return this.name;}
}
