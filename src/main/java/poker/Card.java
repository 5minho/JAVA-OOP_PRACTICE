package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;


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

    public Symbol getSymbol() {
        return symbol;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        Card another = (Card) obj;
        return this.symbol.equals(another.getSymbol()) &&
                this.denomination.equals(another.getDenomination());
    }
}
