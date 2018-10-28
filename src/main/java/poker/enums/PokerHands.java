package poker.enums;

import poker.HoldingCards;
import poker.exceptions.UndefinedPokerHandsException;

import java.util.function.Function;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public enum PokerHands {
    STRAIGHT_FLUSH(HoldingCards::isStraightFlush),
    FLUSH(HoldingCards::isFlush),
    STRAIGHT(HoldingCards::isStraight),
    HIGH_CARD;

    private Function <HoldingCards, Boolean> checkingMethod;

    PokerHands() { }

    PokerHands(Function<HoldingCards, Boolean> checkingMethod) {
        this.checkingMethod = checkingMethod;
    }

    public static PokerHands check(HoldingCards holdingCards) {
        for (PokerHands pokerHands : PokerHands.values()) {
            if (pokerHands == HIGH_CARD) {
                return pokerHands;
            }
            if (pokerHands.checkingMethod.apply(holdingCards)) {
                return pokerHands;
            }
        }
        throw new UndefinedPokerHandsException();
    }

}
