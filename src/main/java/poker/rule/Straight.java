package poker.rule;

import poker.Card;
import poker.Cards;
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

    public Straight(Cards cards) throws NotMatchedPokerHandsException {
        super(cards);
    }

    @Override
    protected void check(Cards holdingCards) throws NotMatchedPokerHandsException {
        List<Card> cards = holdingCards.sorted().getCards();
        if (cards.size() < 1) { throw new NotMatchedPokerHandsException();}

        List<Integer> orders = cards.stream()
                .map(Card::getDenomination)
                .map(Denomination::getOrder)
                .collect(Collectors.toList());

        List<Card> straightCards = new ArrayList<>();

        if (orders.get(0) == 2 && orders.containsAll(Arrays.asList(2, 3, 4, 5, 14))) {
            straightCards.add(cards.get(orders.lastIndexOf(2)));
            straightCards.add(cards.get(orders.lastIndexOf(3)));
            straightCards.add(cards.get(orders.lastIndexOf(4)));
            straightCards.add(cards.get(orders.lastIndexOf(5)));
            straightCards.add(cards.get(orders.lastIndexOf(14)));
            this.cards = straightCards;
            this.name = highCard() + " STRAIGHT";
            return;
        }

        straightCards.add(cards.get(0));
        int curr = straightCards.get(0).getDenomination().getOrder();

        for (Card card : cards.subList(1, cards.size())) {
            int next = card.getDenomination().getOrder();
            if (curr + 1 != next) {
                straightCards.clear();
            }
            curr = card.getDenomination().getOrder();
            straightCards.add(card);
            if (straightCards.size() >= 5) {
                this.cards = straightCards;
                this.name = highCard() + " STRAIGHT";
                return;
            }
        }

        throw new NotMatchedPokerHandsException();
    }

}
