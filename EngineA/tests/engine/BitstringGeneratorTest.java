package engine;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 16:06
 */
public class BitstringGeneratorTest {

    BitstringGenerator bitstringGenerator;

    @Before
    public void setUp() {
        bitstringGenerator = null;
    }

    @Test
    public void should_get_bit_string_of_correct_length() {

        Random random = new Random();
        bitstringGenerator = new BitstringGenerator(random, 8);

        Bitstring randomBitstring = bitstringGenerator.generateRandomBitstring();
        assertEquals(8, randomBitstring.getBits().length);
    }

    @Test
    public void should_get_zero_length_bit_string() {

        Random random = new Random();
        bitstringGenerator = new BitstringGenerator(random, 0);

        Bitstring randomBitstring = bitstringGenerator.generateRandomBitstring();
        assertEquals(0, randomBitstring.getBits().length);
    }

}
