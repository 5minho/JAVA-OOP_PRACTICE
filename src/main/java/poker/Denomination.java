package poker;

import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public enum Denomination {
    two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10),
    J(11), Q(12), K(13),
    A(14);

    private int order;

    Denomination(int order) {
        this.order = order;
    }

    public static List<Denomination> all() {
        return Arrays.asList(
                Denomination.two, Denomination.three, Denomination.four, Denomination.five, Denomination.six,
                Denomination.seven, Denomination.eight, Denomination.nine, Denomination.ten,
                Denomination.J, Denomination.Q, Denomination.K, Denomination.A
        );
    }
}
