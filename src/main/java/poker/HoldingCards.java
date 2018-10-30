package poker;

import poker.enums.Denomination;
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
        super(cards);
    }

    public boolean isFlush() {
        return groupingBySymbol()
                .values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0) >= 5;
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
        return false;
    }

    public boolean isOnePair() {
        return groupingByDenomination().values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(0) >= 2;
    }
}
