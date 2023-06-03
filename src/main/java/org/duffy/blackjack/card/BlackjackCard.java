package org.duffy.blackjack.card;

public class BlackjackCard extends Card {

    public BlackjackCard(int value, SymbolType symbol) {
        super(value, symbol);
    }

    @Override
    public int getValue() {
        // TODO: 카드 문양 + 숫자 점수 계산
        return 0;
    }
}
