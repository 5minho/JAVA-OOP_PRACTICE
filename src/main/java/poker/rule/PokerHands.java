package poker.rule;
import poker.Card;
import poker.Cards;
import poker.exceptions.NotMatchedPokerHandsException;

import java.util.List;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public abstract class PokerHands extends Cards {
    protected String name;
    public PokerHands(Cards cards) throws NotMatchedPokerHandsException {
        check(cards);
    }

    abstract protected void check(Cards cards) throws NotMatchedPokerHandsException;
    abstract protected String suffix();

    protected void init(List<Card> cards) {
        this.cards = cards;
        this.name = highCard() + " " + suffix();
    }

    public String getName() {
        return name;
    }

}


