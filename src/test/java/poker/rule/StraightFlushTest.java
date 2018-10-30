package poker.rule;

import org.junit.Test;
import poker.Card;
import poker.HoldingCards;
import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.NotMatchedPokerHandsException;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class StraightFlushTest {

    @Test
    public void 같은모양_5장이_연속된_숫자이면_STRAIGHT_FLUSH_이다() throws NotMatchedPokerHandsException {
        HoldingCards holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.TWO),
                new Card(Symbol.SPADE, Denomination.THREE),
                new Card(Symbol.SPADE, Denomination.FOUR),
                new Card(Symbol.SPADE, Denomination.FIVE),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        StraightFlush straightFlush = new StraightFlush(holdingCards);
        assertEquals("SPADE A STRAIGHT FLUSH", straightFlush.getName());

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.TWO),
                new Card(Symbol.SPADE, Denomination.THREE),
                new Card(Symbol.SPADE, Denomination.FOUR),
                new Card(Symbol.SPADE, Denomination.FIVE),
                new Card(Symbol.DIAMOND, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.SPADE, Denomination.SIX)
        ));
        straightFlush.check(holdingCards);
        assertEquals("DIAMOND A STRAIGHT FLUSH", straightFlush.getName());
    }
}