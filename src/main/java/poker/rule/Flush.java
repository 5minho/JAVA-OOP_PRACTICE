package poker.rule;

import poker.Card;
import poker.HoldingCards;
import poker.enums.Symbol;
import poker.exceptions.NotMatchedPokerHandsException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class Flush extends PokerHands {

    @Override
    public Info check(HoldingCards holdingCards) throws NotMatchedPokerHandsException {
        Map<Symbol, List<Card>> symbolGroup = holdingCards.groupingBySymbol();
        for (Symbol symbol : symbolGroup.keySet()) {
            if (!symbolGroup.containsKey(symbol)) {
                continue;
            }
            List<Card> cards = symbolGroup.get(symbol);
            if (cards.size() >= 5) {
                Card highCard = Collections.max(cards);
                return new Info(highCard + " FLUSH", highCard);
            }
        }
        throw new NotMatchedPokerHandsException();
    }
}
