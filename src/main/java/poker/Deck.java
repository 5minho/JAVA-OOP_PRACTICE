package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */

public class Deck extends Cards {

    public static int CARD_NUM = 52;

    Deck() {
        super();
        Symbol[] symbols = new Symbol[] {Symbol.SPADE, Symbol.CLOVER, Symbol.DIAMOND, Symbol.HEART};
        for (Symbol symbol : symbols) {
            cards.addAll(Denomination.all()
                    .stream()
                    .map(denomination -> new Card(symbol, denomination))
                    .collect(Collectors.toList()));
        }
    }

    public Deck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

}
