package org.duffy.blackjack.card;

public class BlackjackCardFactory implements CardAbstractFactory {

    private int value;

    private SymbolType symbol;

    public BlackjackCardFactory(int value, SymbolType symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public BlackjackCard createCard() {
        return new BlackjackCard(value, symbol);
    }
}
