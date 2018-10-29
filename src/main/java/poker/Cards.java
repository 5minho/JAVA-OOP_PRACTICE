package poker;

import poker.exceptions.AlreadyExistCardAddException;
import poker.exceptions.NotExistCardRemoveException;

import java.util.List;
import java.util.Stack;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public abstract class Cards {

    protected Stack<Card> cards;

    public Cards() {
        cards = new Stack<>();
    }

    public Cards(List<Card> cards) {
        cards.addAll(cards);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card pop() {
        return cards.pop();
    }

    public void push(Card card) throws AlreadyExistCardAddException {
        if (cards.contains(card)) {
            throw new AlreadyExistCardAddException();
        }
        cards.push(card);
    }

    public void remove(Card card) throws NotExistCardRemoveException {
        if (!cards.contains(card)) {
            throw new NotExistCardRemoveException();
        }
        cards.remove(card);
    }

}
