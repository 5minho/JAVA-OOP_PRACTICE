package poker.rule;
import poker.Card;
import poker.HoldingCards;
import poker.exceptions.NotMatchedPokerHandsException;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 28/10/2018.
 */
public abstract class PokerHands {
    public class Info {
        private String name;
        private Card highCard;

        Info(String name, Card highCard) {
            this.name = name;
            this.highCard = highCard;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Card getHighCard() {
            return highCard;
        }
    }

    private Info info;
    abstract public Info check(HoldingCards holdingCards) throws NotMatchedPokerHandsException;
}


