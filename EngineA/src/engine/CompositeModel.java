package engine;

import java.util.List;

import static util.ListElementChecker.allElementsNonNull;
import static util.ListElementChecker.allNumbersNonNullAndPositive;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:08
 */
public class CompositeModel extends AbstractModel implements Model {

    private final List<Model> models;
    private final List<Integer> weightings;

    private int modelID;

    public CompositeModel(List<Model> models, List<Integer> weightings, int modelID) {

        super();

        assert models.size() == weightings.size();
        assert models.size() > 0;

        assert allElementsNonNull(models);
        assert allElementsNonNull(weightings);
        assert allNumbersNonNullAndPositive(weightings);

        this.models = models;
        this.weightings = weightings;

        this.modelID = modelID;
    }

    @Override
    public int getPredictedFitness(Bitstring bits) {

        long weightedTotal = 0;
        long totalWeighting = 0;

        for (int i = 0; i < models.size(); i++) {
            Model model = models.get(i);
            int weighting = weightings.get(i);

            weightedTotal += model.getPredictedFitness(bits) * weighting;
            totalWeighting += weighting;
        }

        long fitness = weightedTotal / totalWeighting;

        assert fitness <= Integer.MAX_VALUE;

        return (int)fitness;
    }

    @Override
    public int getID() {
        return modelID;
    }

    @Override
    public String toString() {
        return "CompositeModel{" +
                "models=" + models +
                ", weightings=" + weightings +
                '}';
    }
}
