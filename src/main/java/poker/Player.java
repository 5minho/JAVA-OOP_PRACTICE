package poker;

import poker.exceptions.TooManyCardsException;

import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 27/10/2018.
 */

public class Player {

    protected List<Card> cards = new ArrayList<>();

    public void receive(Card card) throws TooManyCardsException {
        if (hasTooManyCard()) {
            throw new TooManyCardsException();
        }
        cards.add(card);
    }

    private boolean hasTooManyCard() {
        return cards.size() >= 7;
    }

    public int cardsCount() {
        return cards.size();
    }

    boolean has(Card card) {
        return cards.contains(card);
    }
}
