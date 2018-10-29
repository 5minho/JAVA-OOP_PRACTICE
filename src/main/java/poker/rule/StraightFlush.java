package poker.rule;

import poker.Card;
import poker.HoldingCards;
import poker.exceptions.NotMatchedPokerHandsException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 30/10/2018.
 */
public class StraightFlush extends Flush {
    @Override
    public Info check(HoldingCards holdingCards) throws NotMatchedPokerHandsException {
        super.check(holdingCards);
        Info straightFlushInfo = new Straight().check(holdingCards);
        Card highCard = straightFlushInfo.getHighCard();
        straightFlushInfo.setName(highCard + " STRAIGHT FLUSH");
        return straightFlushInfo;
    }
}
