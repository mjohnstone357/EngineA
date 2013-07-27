package engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 12:38
 */
public class BitstringTest {

    @Test
    public void constructor_should_parse_bit_string_correctly() {

        Bitstring bitstring = new Bitstring(4, "1010");

        boolean[] bits = bitstring.getBits();

        assertEquals(true, bits[0]);
        assertEquals(false, bits[1]);
        assertEquals(true, bits[2]);
        assertEquals(false, bits[3]);

    }

    @Test
    public void constructor_should_parse_bit_string_correctly_when_first_few_bits_are_not_specified() {

        Bitstring bitstring = new Bitstring(10, "1010");

        boolean[] bits = bitstring.getBits();

        for (int i = 0; i < 6; i++) {
            assertFalse(bits[i]);
        }

        assertEquals(true, bits[6]);
        assertEquals(false, bits[7]);
        assertEquals(true, bits[8]);
        assertEquals(false, bits[9]);

    }

    @Test
    public void constructor_should_parse_empty_string_correctly() {

        Bitstring bitstring = new Bitstring(4, "");

        boolean[] bits = bitstring.getBits();

        for (int i = 0; i < 4; i++) {
            assertFalse(bits[i]);
        }

    }

    @Test
    public void constructor_should_parse_empty_string_and_produce_zero_length_bitstring() {

        Bitstring bitstring = new Bitstring(0, "");

        boolean[] bits = bitstring.getBits();

        assertEquals(0, bits.length);

    }



}
