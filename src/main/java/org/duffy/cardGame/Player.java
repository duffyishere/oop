package org.duffy.cardGame;

public abstract class Player {
    private String name;

    public String getName() {return this.name;}

    public abstract void play();
}
