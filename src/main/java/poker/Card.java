package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class Card {
    private Symbol symbol;
    private Denomination denomination;

    public Card(Symbol symbol, Denomination denomination) {
        this.symbol = symbol;
        this.denomination = denomination;
    }

    public static List<Card> deck() {
        List<Card> cloverCards = new ArrayList<>();
        Symbol[] symbols = new Symbol[] {Symbol.SPADE, Symbol.CLOVER, Symbol.DIAMOND, Symbol.HEART};
        for (Symbol symbol : symbols) {
            cloverCards.addAll(Denomination.all()
                    .stream()
                    .map(denomination -> new Card(symbol, denomination))
                    .collect(Collectors.toList()));
        }
        return cloverCards;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
