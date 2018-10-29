package poker.enums;

import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public enum Denomination {

    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    J(11), Q(12), K(13),
    A(14);

    private int order;

    Denomination(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public static List<Denomination> all() {
        return Arrays.asList(
                Denomination.TWO, Denomination.THREE, Denomination.FOUR, Denomination.FIVE, Denomination.SIX,
                Denomination.SEVEN, Denomination.EIGHT, Denomination.NINE, Denomination.TEN,
                Denomination.J, Denomination.Q, Denomination.K, Denomination.A
        );
    }
}
