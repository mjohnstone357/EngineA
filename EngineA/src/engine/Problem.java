package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 13:10
 */
public interface Problem {

    /**
     * Evaluate the fitness of a Bitstring
     * @param bitstring a Bitstring representing a solution
     * @return the fitness of the given Bitstring
     */
    public int fitness(Bitstring bitstring);

}
