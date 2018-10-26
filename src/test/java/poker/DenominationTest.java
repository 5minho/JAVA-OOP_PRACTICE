package poker;

import org.junit.Test;
import poker.enums.Denomination;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 26/10/2018.
 */
public class DenominationTest {

    @Test
    public void 끗수는_총_13개_이다() {
        assertEquals(13, Denomination.all().size());
    }
}