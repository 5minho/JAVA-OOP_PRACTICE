package poker;

import org.junit.Test;
import poker.enums.Denomination;
import poker.enums.Symbol;


import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class CardTest {

    @Test
    public void Symbol과_Denomination이_같은_카드는_동일한_카드이다() {
        Card card = new Card(Symbol.SPADE, Denomination.A);
        Card aceCard = new Card(Symbol.SPADE, Denomination.A);
        assertEquals(card, aceCard);
    }

    @Test
    public void Symbol이_다른카드는_다른카드로_취급한다() {
        Card diamondACard = new Card(Symbol.DIAMOND, Denomination.A);
        Card heartACard = new Card(Symbol.HEART, Denomination.A);
        assertNotEquals(diamondACard, heartACard);
    }

    @Test
    public void Denomication이_다른카드는_다른카드로_취급한다() {
        Card spade5Card = new Card(Symbol.SPADE, Denomination.five);
        Card spade6Card = new Card(Symbol.SPADE, Denomination.six);
        assertNotEquals(spade5Card, spade6Card);
    }

    @Test
    public void 같은모양의_카드는_끗수가_높을수록_높은카드이다() {
        Card spadeA = new Card(Symbol.SPADE, Denomination.A);
        Card spadeTwo = new Card(Symbol.SPADE, Denomination.two);
        Card spadeThree = new Card(Symbol.SPADE, Denomination.three);

        assertTrue(spadeThree.higherThan(spadeTwo));
        assertTrue(spadeA.higherThan(spadeTwo));
        assertTrue(spadeTwo.lowerThan(spadeA));
    }

    @Test
    public void 같은숫자의_카드는_SPADE_DIAMOND_HEART_CLOVER_순으로_높은카드이다() {
        Card spadeA = new Card(Symbol.SPADE, Denomination.A);
        Card diamondA = new Card(Symbol.DIAMOND, Denomination.A);
        Card heartA = new Card(Symbol.HEART, Denomination.A);
        Card cloverA = new Card(Symbol.CLOVER, Denomination.A);

        assertTrue(spadeA.higherThan(diamondA));
        assertTrue(diamondA.higherThan(heartA));
        assertTrue(heartA.higherThan(cloverA));
    }
}