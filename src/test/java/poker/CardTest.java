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
}