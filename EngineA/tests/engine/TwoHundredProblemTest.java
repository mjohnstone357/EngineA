package engine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 13:12
 */
public class TwoHundredProblemTest {

    private Problem problem;

    @Before
    public void setUp() {
        problem = new TwoHundredProblem();
    }

    @Test
    public void should_evaluate_fitness_of_zero() {

        Bitstring bitstring = new Bitstring(8, "0");

        assertEquals(0, problem.fitness(bitstring));
    }

    @Test
    public void should_evaluate_fitness_of_one() {

        Bitstring bitstring = new Bitstring(8, "1");

        assertEquals(1, problem.fitness(bitstring));
    }

    @Test
    public void should_evaluate_fitness_of_198() {

        Bitstring bitstring = new Bitstring(8, "11000110");

        assertEquals(198, problem.fitness(bitstring));
    }

    @Test
    public void should_evaluate_fitness_of_199() {

        Bitstring bitstring = new Bitstring(8, "11000111");

        assertEquals(199, problem.fitness(bitstring));
    }

    @Test
    public void should_evaluate_fitness_of_200() {

        Bitstring bitstring = new Bitstring(8, "11001000");

        assertEquals(0, problem.fitness(bitstring));
    }

    @Test
    public void should_evaluate_fitness_of_255() {

        Bitstring bitstring = new Bitstring(8, "11111111");

        assertEquals(0, problem.fitness(bitstring));
    }

}
