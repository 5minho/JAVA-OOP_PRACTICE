package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.AlreadyExistCardAddException;
import poker.exceptions.NotExistCardRemoveException;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public class Cards {

    protected List<Card> cards;

    public Cards() {
        cards = new ArrayList<>();
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public Cards sorted() {
        return new Cards(cards.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public int size() {
        return cards.size();
    }

    public Card highCard() { return Collections.max(cards); }

    public List<Card> getCards() {
        return cards;
    }

    public Card pop() {
        if (cards.size() == 0) {
            // 에러 정의하기
            throw new RuntimeException();
        }
        return cards.remove(cards.size() - 1);
    }

    public void push(Card card) throws AlreadyExistCardAddException {
        if (cards.contains(card)) {
            throw new AlreadyExistCardAddException();
        }
        cards.add(card);
    }

    public void remove(Card card) throws NotExistCardRemoveException {
        if (!cards.contains(card)) {
            throw new NotExistCardRemoveException();
        }
        cards.remove(card);
    }

    public Map<Symbol, List<Card>> groupingBySymbol() {
        return cards.stream()
                .collect(groupingBy(Card::getSymbol));
    }

    public Map<Denomination, List<Card>> groupingByDenomination() {
        return cards.stream()
                .collect(groupingBy(Card::getDenomination));
    }

}
