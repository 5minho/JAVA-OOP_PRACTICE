package poker.rule;

import org.junit.Test;
import poker.Card;
import poker.HoldingCards;
import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.NotMatchedPokerHandsException;
import poker.rule.Straight;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class StraightTest {

    @Test
    public void 연속된_숫자가_5개_이상_이면_STRAIGHT_이다() throws NotMatchedPokerHandsException {
        HoldingCards holdingCards;
        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.SEVEN),
                new Card(Symbol.HEART, Denomination.FIVE),
                new Card(Symbol.SPADE, Denomination.SIX),
                new Card(Symbol.DIAMOND, Denomination.EIGHT),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.NINE),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        Straight straight = new Straight(holdingCards);
        assertEquals("DIAMOND NINE STRAIGHT", straight.getName());

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.TWO),
                new Card(Symbol.HEART, Denomination.THREE),
                new Card(Symbol.SPADE, Denomination.FOUR),
                new Card(Symbol.DIAMOND, Denomination.FIVE),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));
        straight = new Straight(holdingCards);
        assertEquals("HEART A STRAIGHT", straight.getName());

        holdingCards = new HoldingCards(Arrays.asList(
                new Card(Symbol.SPADE, Denomination.TWO),
                new Card(Symbol.HEART, Denomination.J),
                new Card(Symbol.SPADE, Denomination.FOUR),
                new Card(Symbol.DIAMOND, Denomination.TEN),
                new Card(Symbol.HEART, Denomination.A),
                new Card(Symbol.DIAMOND, Denomination.K),
                new Card(Symbol.CLOVER, Denomination.Q)
        ));

        straight = new Straight(holdingCards);
        assertEquals("HEART A STRAIGHT", straight.getName());
    }
}