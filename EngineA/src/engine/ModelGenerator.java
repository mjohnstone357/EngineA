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
    private final int stringLength;
    private final List<Model> existingModels;

    private final BitModelGenerator bitModelGenerator;
    private final CompositeModelGenerator compositeModelGenerator;

    public ModelGenerator(Random random, int stringLength, List<Model> existingModels) {
        this.random = random;
        this.stringLength = stringLength;
        this.existingModels = existingModels;

        this.bitModelGenerator = new BitModelGenerator(random, stringLength);
        this.compositeModelGenerator = new CompositeModelGenerator(random, stringLength, existingModels);
    }

    public Model createRandomModel() {

        if (!compositeModelGenerator.canCreateModel() || random.nextBoolean()) {
            return bitModelGenerator.generateRandomBitModel();
        } else {
            return compositeModelGenerator.generateRandomCompositeModel();
        }

    }
}
