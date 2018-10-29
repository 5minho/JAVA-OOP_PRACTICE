package poker;

import poker.exceptions.TooManyCardsException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 27/10/2018.
 */

public class Player {

    private Cards holdingCards = new HoldingCards();

    public void receive(Card card) throws TooManyCardsException {
        if (hasTooManyCard()) {
            throw new TooManyCardsException();
        }
        holdingCards.push(card);
    }

    private boolean hasTooManyCard() {
        return holdingCards.size() >= 7;
    }

    public int cardsCount() {
        return holdingCards.size();
    }

}
