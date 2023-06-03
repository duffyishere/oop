package org.duffy.blackjack.game;

import org.duffy.blackjack.card.BlackjackCard;
import org.duffy.blackjack.card.Card;
import org.duffy.blackjack.deck.Deck;
import org.duffy.blackjack.player.DefaultPlayer;

import java.math.BigDecimal;
import java.util.List;

public class BlackjackGame extends Game implements BetAble {

    private BigDecimal bettedMoney;

    public BlackjackGame(List<DefaultPlayer> players) {
        super(new Deck<BlackjackCard>(), players);
    }

    public BlackjackGame(Deck<? extends Card> deck) {
        super(deck);
    }

    @Override
    public Card drawingCard() {
        Card drawedCard = getDeck().draw();
        moveOnNextPlayer();

        return drawedCard;
    }

    private void moveOnNextPlayer() {
        if (getNowPlayerIndex() < getPlayers().size()-1) {
            setRound(getRound()+1);
            setNowPlayerIndex(0);
            setNowPlayer(getPlayers().get(getNowPlayerIndex()));
        }
        else {
            setNowPlayerIndex(getNowPlayerIndex());
            setNowPlayer(getPlayers().get(getNowPlayerIndex()));
        }
    }

    public BigDecimal getBettedMoney() {
        return bettedMoney;
    }

    public void setBettedMoney(BigDecimal bettedMoney) {
        this.bettedMoney = bettedMoney;
    }

    @Override
    public void betting(BigDecimal amount) {
        this.bettedMoney.add(amount);
    }
}
