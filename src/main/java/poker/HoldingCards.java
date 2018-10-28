package poker;

import poker.Card;
import poker.enums.PokerHands;

import java.util.List;
import java.util.Stack;
import java.util.function.Function;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public class HoldingCards extends CardBundle {

    HoldingCards() {
        super();
    }

    HoldingCards(List<Card> cards) {
        super();
        this.cards.addAll(cards);
    }

    public PokerHands pokerHands() {
        if (PokerHands.STRAIGHT_FLUSH.check(this)) {
            return PokerHands.STRAIGHT_FLUSH;
        }
        return null;
    }
}
