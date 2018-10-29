package poker.enums;

import org.junit.Test;
import poker.Card;
import poker.HoldingCards;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public class PokerHandsTest {

    private HoldingCards holdingCards;

    @Test
    public void 같은모양_5장이_연속된_숫자이면_STRAIGHT_FLUSH_이다() {
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.two),
                new Card(Symbol.SPADE, Denomination.three),
                new Card(Symbol.SPADE, Denomination.four),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));

        assertEquals(PokerHands.STRAIGHT_FLUSH, PokerHands.check(holdingCards));

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.two),
                new Card(Symbol.SPADE, Denomination.three),
                new Card(Symbol.SPADE, Denomination.four),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.DIAMOND, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.SPADE, Denomination.six)
        ));

        assertEquals(PokerHands.STRAIGHT_FLUSH, PokerHands.check(holdingCards));
    }

    @Test
    public void 같은모양이_5장_이상이면_FLUSH_이다() {
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.seven),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.DIAMOND, Denomination.six),
                new Card(Symbol.SPADE, Denomination.eight),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.J),
                new Card(Symbol.SPADE, Denomination.Q)
        ));
        assertEquals(PokerHands.FLUSH, PokerHands.check(holdingCards));

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.seven),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.SPADE, Denomination.six),
                new Card(Symbol.SPADE, Denomination.eight),
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.J),
                new Card(Symbol.SPADE, Denomination.Q)
        ));
        assertEquals(PokerHands.FLUSH, PokerHands.check(holdingCards));

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.seven),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.SPADE, Denomination.six),
                new Card(Symbol.DIAMOND, Denomination.eight),
                new Card(Symbol.DIAMOND, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.J),
                new Card(Symbol.SPADE, Denomination.Q)
        ));
        assertNotEquals(PokerHands.FLUSH, PokerHands.check(holdingCards));
    }

    @Test
    public void 연속된_숫자가_5개_이상_이면_STRAIGHT_이다() {
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.seven),
                new Card(Symbol.HEART, Denomination.five),
                new Card(Symbol.SPADE, Denomination.six),
                new Card(Symbol.DIAMOND, Denomination.eight),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.nine),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        assertEquals(PokerHands.STRAIGHT, PokerHands.check(holdingCards));

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.two),
                new Card(Symbol.HEART, Denomination.three),
                new Card(Symbol.SPADE, Denomination.four),
                new Card(Symbol.DIAMOND, Denomination.five),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        assertEquals(PokerHands.STRAIGHT, PokerHands.check(holdingCards));

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.two),
                new Card(Symbol.HEART, Denomination.J),
                new Card(Symbol.SPADE, Denomination.four),
                new Card(Symbol.DIAMOND, Denomination.ten),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        assertEquals(PokerHands.STRAIGHT, PokerHands.check(holdingCards));
    }

    @Test
    public void 같은_숫자가_두장이면_OnePair_이다() {
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.ten),
                new Card(Symbol.HEART, Denomination.four),
                new Card(Symbol.DIAMOND, Denomination.J),
                new Card(Symbol.CLOVER, Denomination.five),
                new Card(Symbol.CLOVER, Denomination.A),
                new Card(Symbol.SPADE, Denomination.three)
        ));
        assertEquals(PokerHands.ONE_PAIR, PokerHands.check(holdingCards));
    }
}