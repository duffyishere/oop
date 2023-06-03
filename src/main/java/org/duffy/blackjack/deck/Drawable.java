package org.duffy.blackjack.deck;

import org.duffy.blackjack.card.Card;

public interface Drawable<T extends Card> {

    T draw();
}
