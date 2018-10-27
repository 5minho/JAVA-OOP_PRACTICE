package poker;

import poker.exceptions.NotExistCardRemoveException;
import poker.exceptions.TooManyCardsException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class Dealer {
    private Deck deck;

    public Dealer() {}

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public void passCard(Player player) {
        pass(deck.pop(), player);
    }

    private void pass(Card card, Player player) {
        try {
            player.receive(card);
        } catch (TooManyCardsException e) {
            deck.push(card);
        }
    }
}
