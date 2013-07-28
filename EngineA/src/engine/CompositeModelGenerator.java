package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 16:32
 */
public class CompositeModelGenerator {

    private final Random random;
    private final List<Model> existingModels;
    private final BitModelGenerator bitModelGenerator;

    public CompositeModelGenerator(Random random, int stringLength, List<Model> existingModels) {
        this.random = random;
        this.existingModels = existingModels;
        bitModelGenerator = new BitModelGenerator(random, stringLength);
    }

    public CompositeModel generateRandomCompositeModel() {

        final int numberOfModels = existingModels.size();

        final List<Model> modelsList = new ArrayList<>(existingModels);

        final int numberOfSelectedModels = 1 + random.nextInt(numberOfModels);

        final List<Model> modelsToUse = new ArrayList<>();
        final List<Integer> weightings = new ArrayList<>();

        for (int i = 0; i < numberOfSelectedModels; i++) {

            final int index = random.nextInt(modelsList.size());

            Model model = modelsList.get(index);
            modelsToUse.add(model);
            modelsList.remove(index);

            weightings.add(bitModelGenerator.getRandomWeighting());
        }

        return new CompositeModel(modelsToUse, weightings);

    }

    public boolean canCreateModel() {
        return existingModels.size() > 0;
    }
}
