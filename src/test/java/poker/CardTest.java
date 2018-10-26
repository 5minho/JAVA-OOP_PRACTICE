package poker;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class CardTest {

    @Test
    public void Card_deck_은_52장의_카드뭉치다() {
        List<Card> cards = Card.deck();
        assertEquals(cards.size(), 52);
    }

    @Test
    public void Card_deck_은_4종류의_모양이있다() {
        long symbolCount = Card.deck()
                .stream()
                .map(Card::getSymbol)
                .distinct()
                .count();
        assertEquals(4, symbolCount);
    }

    @Test
    public void Card_deck_은_13종류의_끗수가_있다() {
        long denoCount = Card.deck()
                .stream()
                .map(Card::getDenomination)
                .distinct()
                .count();
        assertEquals(13, denoCount);
    }
}