package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class Game {
    private Dealer dealer;

    public void prepare() {
        Deck deck = new Deck();
        dealer = new Dealer(deck);
    }

    public Dealer getDealer() {
        return dealer;
    }
}
