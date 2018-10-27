package poker;

import org.junit.Before;
import org.junit.Test;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void Game_객체는_게임_시작_전_Dealer_와_Deck_을_생성해_Dealer_에게_Deck_을_주입해준다() {
        game.prepare();
    }

}