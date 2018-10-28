package poker;

import poker.exceptions.AlreadyExistCardAddException;
import poker.exceptions.NotExistCardRemoveException;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public abstract class CardBundle {

    protected Stack<Card> cards;

    CardBundle() {
        cards = new Stack<>();
    }

    protected int size() {
        return cards.size();
    }

    protected List<Card> getCards() {
        return cards;
    }

    protected Card pop() {
        return cards.pop();
    }

    protected void push(Card card) throws AlreadyExistCardAddException {
        if (cards.contains(card)) {
            throw new AlreadyExistCardAddException();
        }
        cards.push(card);
    }

    protected void remove(Card card) throws NotExistCardRemoveException {
        if (!cards.contains(card)) {
            throw new NotExistCardRemoveException();
        }
        cards.remove(card);
    }

    protected void sortByDenomination() {
//        cards.sort();
    }
}
