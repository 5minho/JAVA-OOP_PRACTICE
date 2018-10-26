package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class Deck {
    private List<Card> cards;

    Deck() {
        List<Card> cards = new ArrayList<>();
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
}
