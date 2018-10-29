package poker.rule;

import poker.Card;
import poker.HoldingCards;
import poker.enums.Denomination;
import poker.exceptions.NotMatchedPokerHandsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class Straight extends PokerHands {

    @Override
    public Info check(HoldingCards holdingCards) throws NotMatchedPokerHandsException {
        List<Card> cards = holdingCards.sorted().getCards();
        if (cards.size() < 1) { throw new NotMatchedPokerHandsException();}

        List<Integer> orders = cards.stream()
                .map(Card::getDenomination)
                .map(Denomination::getOrder)
                .collect(Collectors.toList());

        int sequenceNum = 1;
        int curr = orders.get(0);

        if (curr == 2 && orders.containsAll(Arrays.asList(2, 3, 4, 5, 14))) {
            Card highCard = cards.get(orders.lastIndexOf(5));
            return new Info(highCard + " STRAIGHT", highCard);
        }

        for (int i = 1 ; i < orders.size() ; i++) {
            int next = orders.get(i);
            sequenceNum = (curr + 1 == next) ? sequenceNum + 1 : 1;
            if (sequenceNum >= 5) {
                Card highCard = cards.get(i);
                return new Info(highCard + " STRAIGHT", highCard);
            }
            curr = next;
        }

        throw new NotMatchedPokerHandsException();
    }

}
