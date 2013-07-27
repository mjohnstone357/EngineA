package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 13:03
 */
public interface Model {

    /**
     * Get this Model's prediction for the fitness of a given Bitstring. In the ideal case, the model will correctly
     * determine the exact fitness of all possible Bitstrings. A Model has its own concept of fitness- the extent to
     * which it can accurately predict the fitness of a sample of Bitstrings.
     * @param bits a string of bits
     * @return this Model's prediction of the given Bitstring's fitness
     */
    public int getPredictedFitness(Bitstring bits);

}
