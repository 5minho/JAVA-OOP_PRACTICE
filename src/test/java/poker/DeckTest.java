package poker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void 덱은_골고루_섞여야_한다() {

    }

    @Test
    public void Card_deck_은_52장의_카드뭉치다() {
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    public void Card_deck_은_4종류의_모양이있다() {
        long symbolCount = deck.getCards()
                .stream()
                .map(Card::getSymbol)
                .distinct()
                .count();
        assertEquals(4, symbolCount);
    }

    @Test
    public void Card_deck_은_13종류의_끗수가_있다() {
        long denoCount = deck.getCards()
                .stream()
                .map(Card::getDenomination)
                .distinct()
                .count();
        assertEquals(13, denoCount);
    }

}