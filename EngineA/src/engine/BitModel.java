package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 14:58
 */
public class BitModel extends AbstractModel implements Model {

    private final int index;
    private final int fitnessPrediction;

    public BitModel(int index, int fitnessPrediction) {
        super();
        this.index = index;
        this.fitnessPrediction = fitnessPrediction;
    }

    @Override
    public int getPredictedFitness(Bitstring bits) {

        boolean bit = bits.getBits()[index];

        if (bit) {
            return fitnessPrediction;
        } else {
            return -fitnessPrediction;
        }

    }

    @Override
    public String toString() {
        return "BitModel{" +
                "index=" + index +
                ", fitnessPrediction=" + fitnessPrediction +
                '}';
    }
}
