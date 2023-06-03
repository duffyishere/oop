package org.duffy.blackjack.card;

public abstract class Card {

    private int value;

    private SymbolType symbol;

    public Card(int value, SymbolType symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public abstract int getValue();

    public SymbolType getSymbol() {
        return symbol;
    }
}
