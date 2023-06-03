package org.duffy.blackjack.player;

import org.duffy.blackjack.card.Card;
import org.duffy.blackjack.game.Game;

import java.math.BigDecimal;
import java.util.List;

public class DefaultPlayer extends Player {

    public DefaultPlayer(String name, Game game, List<Card> handedCards, BigDecimal amount) {
        super(name, game, handedCards, amount);
    }

    @Override
    public Card draw() {
        Card drawedCard = getGame().drawingCard();
        getHandedCards().add(drawedCard);

        return drawedCard;
    }
}
