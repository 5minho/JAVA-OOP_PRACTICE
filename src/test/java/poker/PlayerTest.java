package poker;

import org.junit.Before;
import org.junit.Test;
import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.TooManyCardsException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 27/10/2018.
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void 플레이어는_카드를_받을_수_있다() throws TooManyCardsException {
        assertEquals(0, player.cardsCount());
        player.receive(new Card(Symbol.SPADE, Denomination.A));
        assertEquals(1, player.cardsCount());
    }

    @Test(expected = TooManyCardsException.class)
    public void 플레이어는_최대로_7장의_카드만_받을_수_있다() throws TooManyCardsException {
        give7CardsToPlayer();
        player.receive(new Card(Symbol.SPADE, Denomination.eight));
    }

    private void give7CardsToPlayer() {
        List<Card> cards = Arrays.asList(
                new Card(Symbol.SPADE, Denomination.A),
                new Card(Symbol.SPADE, Denomination.two),
                new Card(Symbol.SPADE, Denomination.three),
                new Card(Symbol.SPADE, Denomination.four),
                new Card(Symbol.SPADE, Denomination.five),
                new Card(Symbol.SPADE, Denomination.six),
                new Card(Symbol.SPADE, Denomination.seven)
        );
        try {
            for (Card card : cards) {
                player.receive(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void has() {
    }
}