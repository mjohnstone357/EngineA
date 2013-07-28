package engine;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Kinda testing the wrong thing here, but it'll do for now.
 *
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 16:39
 */
public class BitModelGeneratorTest {

    private BitModelGenerator bitModelGenerator;

    @Before
    public void setUp() {
        bitModelGenerator = null;
    }

    @Test
    public void should_generate_bit_model() {

        Random mockRandom = createMock(Random.class);
        expect(mockRandom.nextInt(8)).andReturn(5); // Getting the bit index
        expect(mockRandom.nextInt(99)).andReturn(43); // Getting the weighting
        replay(mockRandom);

        bitModelGenerator = new BitModelGenerator(mockRandom, 8);
        BitModel bitModel = bitModelGenerator.generateRandomBitModel();

        assertEquals(44, bitModel.getPredictedFitness(new Bitstring(8, "00000100")));
        verify(mockRandom);

    }
}
