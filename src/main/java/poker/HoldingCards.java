package poker;

import poker.enums.Denomination;
import poker.enums.PokerHands;
import poker.enums.Symbol;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public class HoldingCards extends Cards {

    HoldingCards() {
        super();
    }

    public HoldingCards(List<Card> cards) {
        super();
        this.cards.addAll(cards);
    }

    public Card highCard() {
        return Collections.max(cards);
    }

    public HoldingCards sorted() {
        return new HoldingCards(cards.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public boolean isFlush() {
        return groupingBySymbol()
                .values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0) >= 5;
    }

    public boolean isStraight() {
        return isStraight(cards);
    }

    private boolean isStraight(List<Card> cards) {
        if (cards.size() < 1) { return false; }
        List<Integer> orders = cards.stream()
                .map(Card::getDenomination)
                .map(Denomination::getOrder)
                .sorted()
                .collect(Collectors.toList());

        int sequenceNum = 1;
        int curr = orders.get(0);

        if (curr == 2 && orders.containsAll(Arrays.asList(2, 3, 4, 5, 14))) {
            return true;
        }

        for (int next : orders.subList(1, orders.size())) {
            sequenceNum = (curr + 1 == next) ? sequenceNum + 1 : 1;
            if (sequenceNum >= 5) { return true; }
            curr = next;
        }

        return false;
    }

    private Map<Symbol, List<Card>> groupingBySymbol() {
        return cards.stream()
                .collect(groupingBy(Card::getSymbol));
    }

    private Map<Denomination, List<Card>> groupingByDenomination() {
        return cards.stream()
                .collect(groupingBy(Card::getDenomination));
    }

    public boolean isStraightFlush() {
        if (!isFlush()) {
            return false;
        }
        List<Card> cards = groupingBySymbol().values()
                .stream()
                .filter(groupingCards -> groupingCards.size() >= 5)
                .findAny()
                .orElse(new ArrayList<>());
        return isStraight(cards);
    }

    public boolean isOnePair() {
        return groupingByDenomination().values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0) >= 2;
    }
}
