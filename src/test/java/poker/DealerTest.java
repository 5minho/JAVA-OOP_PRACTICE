package poker;

import org.junit.Before;
import org.junit.Test;
import poker.exceptions.TooManyCardsException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class DealerTest {

    private Dealer dealer;

    @Before
    public void setUp() {
        Game game = new Game();
        game.prepare();
        dealer = game.getDealer();
    }

    @Test
    public void dealer는_player_에게_카드를_줄_수_있다() {
        Player mockPlayer = mock(Player.class);
        dealer.passCard(mockPlayer);
        try {
            verify(mockPlayer).receive(any(Card.class));
        } catch (TooManyCardsException e) {
            fail();
        }
    }
}