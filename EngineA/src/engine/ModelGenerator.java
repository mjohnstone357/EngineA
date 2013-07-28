package engine;

import java.util.List;
import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 16:23
 */
public class ModelGenerator {

    private final Random random;

    private final BitModelGenerator bitModelGenerator;
    private final CompositeModelGenerator compositeModelGenerator;

    public ModelGenerator(Random random, int stringLength, List<Model> existingModels) {
        this.random = random;
        this.bitModelGenerator = getBitModelGenerator(random, stringLength);
        this.compositeModelGenerator = getCompositeModelGenerator(random, stringLength, existingModels);
    }

    protected CompositeModelGenerator getCompositeModelGenerator(Random random, int stringLength, List<Model> existingModels) {
        return new CompositeModelGenerator(random, stringLength, existingModels);
    }

    protected BitModelGenerator getBitModelGenerator(Random random, int stringLength) {
        return new BitModelGenerator(random, stringLength);
    }

    public Model createRandomModel() {

        if (!compositeModelGenerator.canCreateModel() || random.nextInt(10) > 0) {
            return bitModelGenerator.generateRandomBitModel();
        } else {
            return compositeModelGenerator.generateRandomCompositeModel();
        }

    }
}
