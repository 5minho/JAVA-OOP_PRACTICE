package poker;

import com.sun.tools.corba.se.idl.constExpr.Not;
import org.junit.Before;
import org.junit.Test;
import poker.enums.Denomination;
import poker.enums.Symbol;
import poker.exceptions.AlreadyExistCardAddException;
import poker.exceptions.NotExistCardRemoveException;

import java.util.ArrayList;
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
    public void deck_은_골고루_섞일_수_있다() {
        List<Card> beforeShuffle = new ArrayList<>(Deck.CARD_NUM);
        List<Card> afterShuffle = new ArrayList<>(Deck.CARD_NUM);

        beforeShuffle.addAll(deck.getCards());
        afterShuffle.addAll(deck.shuffle().getCards());

        boolean sameOrder = true;

        for (int i = 0 ; i < beforeShuffle.size(); i++) {
            if (!beforeShuffle.get(i).equals(afterShuffle.get(i))) {
                sameOrder = false;
            }
        }

        assertFalse(sameOrder);
    }

    @Test
    public void Card_deck_은_52장의_중복이_없는_카드뭉치다() {
        assertEquals(deck.getCards()
                .stream()
                .distinct()
                .count(), 52);
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

    @Test
    public void Deck_에서_카드한장을_뽑을수_있다() {
        assertEquals(52, deck.size());
        deck.pop();
        assertEquals(51, deck.size());
    }

    @Test(expected = AlreadyExistCardAddException.class)
    public void 이미_Deck에_존재하는_카드를_추가하려하면_예외가_발생한다() {
        Card card = new Card(Symbol.DIAMOND, Denomination.A);
        deck.push(card);
    }

    @Test(expected = NotExistCardRemoveException.class)
    public void 없는_카드를_Deck에서_제거하려하면_예외가_발생한다() throws NotExistCardRemoveException {
        Card card = deck.pop();
        deck.remove(card);
    }

}