package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 14:58
 */
public class BitModel extends AbstractModel implements Model {

    private final int index;
    private final int fitnessPrediction;

    private int modelID;

    public BitModel(int index, int fitnessPrediction, int modelID) {
        super();
        this.index = index;
        this.fitnessPrediction = fitnessPrediction;
        this.modelID = modelID;
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
    public int getID() {
        return modelID;
    }

    @Override
    public String toString() {
        return "BitModel{" +
                "index=" + index +
                ", fitnessPrediction=" + fitnessPrediction +
                '}';
    }
}
