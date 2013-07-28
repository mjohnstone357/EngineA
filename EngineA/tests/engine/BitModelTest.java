package engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:00
 */
public class BitModelTest {

    @Test
    public void should_give_correct_fitness_prediction() {

        Bitstring bitstring = new Bitstring(8, "10000000");
        BitModel bitModel = new BitModel(0, 1000, 0);

        assertEquals(1000, bitModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_fitness_prediction_from_middle_bit() {

        Bitstring bitstring = new Bitstring(8, "00001000");
        BitModel bitModel = new BitModel(4, 1000, 0);

        assertEquals(1000, bitModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_inverse_fitness_prediction() {

        Bitstring bitstring = new Bitstring(8, "11111011");
        BitModel bitModel = new BitModel(5, 1000, 0);

        assertEquals(-1000, bitModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_inverse_fitness_prediction_2() {

        Bitstring bitstring = new Bitstring(8, "11111011");
        BitModel bitModel = new BitModel(5, -1000, 0);

        assertEquals(1000, bitModel.getPredictedFitness(bitstring));
    }

}
