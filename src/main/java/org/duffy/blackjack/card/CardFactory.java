package org.duffy.blackjack.card;

public class CardFactory {

    public static Card getCard(CardAbstractFactory factory) {
        // TODO: 게임 별 카드 덱 반환
        return factory.createCard();
    }
}
