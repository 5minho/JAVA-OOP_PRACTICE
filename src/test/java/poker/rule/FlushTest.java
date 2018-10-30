package poker.rule;

import org.junit.Test;
import poker.Card;
import poker.HoldingCards;
import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.NotMatchedPokerHandsException;
import poker.rule.Flush;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class FlushTest {
    @Test
    public void 같은모양이_5장_이상이면_FLUSH_이다() throws NotMatchedPokerHandsException {
        HoldingCards holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.SEVEN),
                new Card(Symbol.SPADE, Denomination.FIVE),
                new Card(Symbol.DIAMOND, Denomination.SIX),
                new Card(Symbol.SPADE, Denomination.EIGHT),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.J),
                new Card(Symbol.SPADE, Denomination.Q)
        ));

        Flush flush = new Flush(holdingCards);
        assertEquals("SPADE A FLUSH", flush.getName());

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.DIAMOND, Denomination.SEVEN),
                new Card(Symbol.DIAMOND, Denomination.FIVE),
                new Card(Symbol.DIAMOND, Denomination.SIX),
                new Card(Symbol.DIAMOND, Denomination.EIGHT),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.SPADE, Denomination.J),
                new Card(Symbol.DIAMOND, Denomination.NINE)
        ));

        flush = new Flush(holdingCards);
        assertEquals("DIAMOND NINE FLUSH", flush.getName());
    }
}