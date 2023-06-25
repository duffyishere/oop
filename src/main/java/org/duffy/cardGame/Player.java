package org.duffy.cardGame;

import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> handCards;

    public abstract void play();
    public abstract void draw();

    public String getName() {return this.name;}
}
