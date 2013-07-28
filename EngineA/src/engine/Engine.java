package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:52
 */
public class Engine {

    private List<Model> models;
    private Random random;
    private BitstringGenerator bitstringGenerator;
    private ModelGenerator modelGenerator;

    private Problem problem;

    public Engine() {

        models = new ArrayList<>();
        random = new Random();
        bitstringGenerator = new BitstringGenerator(random, 8);
        modelGenerator = new ModelGenerator(random, 8, models);

        problem = new TwoHundredProblem();

    }

    public void tick() {

        Bitstring randomBitstring = bitstringGenerator.generateRandomBitstring();

        Model randomModel1 = modelGenerator.createRandomModel();
        Model randomModel2 = modelGenerator.createRandomModel();

        models.add(randomModel1);
        models.add(randomModel2);

        doTokens(randomBitstring);

    }

    private void doTokens(Bitstring randomBitstring) {

        final int actualFitness = problem.fitness(randomBitstring);

        Model worstModel = models.iterator().next();
        int maxDelta = Math.abs(actualFitness - worstModel.getPredictedFitness(randomBitstring));

        for (Model model : models) {
            int modelPredictedFitness = model.getPredictedFitness(randomBitstring);

            final int delta = Math.abs(actualFitness - modelPredictedFitness);

            if (delta > maxDelta) {
                maxDelta = delta;
                worstModel = model;
            }
        }

        models.remove(worstModel);
    }

    public void run() {
        while (models.size() < 10) {
            tick();
        }
        System.out.println();
    }

    public List<Model> getModels() {
        return models;
    }

    public static void main(String[] args) {
        Engine engine = new Engine();

        engine.run();

        Bitstring opt = new Bitstring(8, "11000111");


        for (Model model : engine.getModels()) {
            System.out.println("Model: " + model + " puts OPT's fitness at " + model.getPredictedFitness(opt));
        }
    }
}
