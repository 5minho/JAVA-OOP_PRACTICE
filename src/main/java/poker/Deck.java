package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.AlreadyExistCardAddException;
import poker.exceptions.NotExistCardRemoveException;
import poker.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */

public class Deck {
    private Stack<Card> cards;
    public static int CARD_NUM = 52;

    Deck() {
        Stack<Card> cards = new Stack<>();
        Symbol[] symbols = new Symbol[] {Symbol.SPADE, Symbol.CLOVER, Symbol.DIAMOND, Symbol.HEART};
        for (Symbol symbol : symbols) {
            cards.addAll(Denomination.all()
                    .stream()
                    .map(denomination -> new Card(symbol, denomination))
                    .collect(Collectors.toList()));
        }
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Deck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

    public int size() {
        return cards.size();
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

    public Card pop() {
        return cards.pop();
    }
}
