package poker;

import poker.enums.Denomination;
import poker.enums.Symbol;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class Card implements Comparable<Card> {

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

    public boolean higherThan(Card card) {
        return compareTo(card) > 0;
    }

    public boolean lowerThan(Card card) {
        return compareTo(card) < 0;
    }

    @Override
    public int compareTo(Card o) {
        if (this.denomination == o.getDenomination()) {
            return this.symbol.compareTo(o.getSymbol());
        }
        return this.denomination.compareTo(o.getDenomination());
    }

    @Override
    public String toString() {
        return symbol + " " + denomination;
    }
}
