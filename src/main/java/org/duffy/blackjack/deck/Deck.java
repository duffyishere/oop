package org.duffy.blackjack.deck;

import org.duffy.blackjack.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck<T extends Card> implements Drawable<T> {

    private List<T> cards = new ArrayList<>();

    private int size;

    public Deck() {
        // TODO: 카드 생성
    }

    public void shuffle() {
        // TODO: 카드 섞기
    }

    public T draw() {
        if (size <= 0) throw new IllegalArgumentException("No more cards to draw.");
        size--;
        return cards.get(0);
    }
}
