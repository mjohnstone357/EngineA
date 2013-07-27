package engine;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Kinda testing the wrong thing here, but it'll do for now.
 *
 * TODO Fix scope of these tests. Maybe set up a mocking framework. Or anonymous subclassing?
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
    public void should_generate_bit_model_1() {
        bitModelGenerator = new BitModelGenerator(new Random(0), 8);
        BitModel bitModel = bitModelGenerator.generateRandomBitModel(); // index: 5, fitness -48

        assertEquals(-48, bitModel.getPredictedFitness(new Bitstring(8, "00000100")));
    }

    @Test
    public void should_generate_bit_model_2() {
        bitModelGenerator = new BitModelGenerator(new Random(0), 8);
        BitModel bitModel = bitModelGenerator.generateRandomBitModel(); // index: 5, fitness -48

        assertEquals(48, bitModel.getPredictedFitness(new Bitstring(8, "00000000")));
    }

    @Test
    public void should_generate_bit_model_3() {
        bitModelGenerator = new BitModelGenerator(new Random(1120565721), 8);
        BitModel bitModel = bitModelGenerator.generateRandomBitModel(); // index: 4, fitness 77

        assertEquals(77, bitModel.getPredictedFitness(new Bitstring(8, "00001000")));
    }

    @Test
    public void should_generate_bit_model_4() {
        bitModelGenerator = new BitModelGenerator(new Random(1120565721), 8);
        BitModel bitModel = bitModelGenerator.generateRandomBitModel(); // index: 4, fitness 77

        assertEquals(-77, bitModel.getPredictedFitness(new Bitstring(8, "0000000")));
    }

}
