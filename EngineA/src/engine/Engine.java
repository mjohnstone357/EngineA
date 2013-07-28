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
    private BitstringGenerator bitstringGenerator;
    private ModelGenerator modelGenerator;

    private final Bitstring opt;

    private Problem problem;

    private int generation;

    private int discardedModelCount;

    public Engine(long seed) {

        models = new ArrayList<>();
        Random random = new Random(seed);
        bitstringGenerator = new BitstringGenerator(random, 8);
        modelGenerator = new ModelGenerator(random, 8, models);

        problem = new EightBitProblem();

        opt = new Bitstring(8, "11000111");

        generation = 0;

        discardedModelCount = 0;
    }

    public List<Model> getModels() {
        return models;
    }

    public void step() {

        Bitstring randomBitstring = bitstringGenerator.generateRandomBitstring();

        if (models.size() < 10) {
            models.add(modelGenerator.createRandomModel());
        }

        int actualFitness = problem.fitness(randomBitstring);

//        System.out.println("=== Generation: " + generation + " =====================");

//        System.out.println("Actual fitness of current string: " + actualFitness);

        int totalCreditsAwarded = 0;

        for (Model model : models) {
            int predictedFitness = model.getPredictedFitness(randomBitstring);
            int delta = Math.abs(actualFitness - predictedFitness);
            int creditReward = 200 - delta;
            model.addCredits(creditReward);
//            System.out.println("Model puts fitness at: " + predictedFitness + ". Delta is " + delta + ". Credit reward is " + creditReward + ". Model: " + model);
            totalCreditsAwarded += creditReward;
        }

//        System.out.println("*** Subtracting average credits. ***");

        int averageCreditAward = totalCreditsAwarded / models.size();

        for (Model model : models) {
            model.subtractCredits((int) (1.1 * averageCreditAward));
//            System.out.println("Model ended up with " + model.getCredits() + " credits.");
        }

        List<Model> modelsToRemove = new ArrayList<>();
        for (Model model : models) {
            if (model.getCredits() < 0) {
//                System.out.println("Removing a model with negative balance.");
                discardedModelCount++;
                modelsToRemove.add(model);
            }
        }

        for (Model model : modelsToRemove) {
            models.remove(model);
        }

//        System.out.println("Absolute info");
        for (Model model : models) {
            System.out.print(modelCorrectness(model) + " ");
        }
        System.out.println();

//        System.out.println("=======================================");

        generation++;
    }

    public static void main(String[] args) {

        Engine engine = new Engine(1000000L);

//        engine.models.add(new BitModel())

        for (int i = 0; i < 250; i++) {
            engine.step();
        }

        System.out.println("Done. " + engine.discardedModelCount + " models were discarded.");

        for (Model model : engine.models) {
            System.out.println(model);
        }

    }

    private int modelCorrectness(Model model) {

        int totalError = 0;

        for (int i = 0; i < 256; i++) {
            boolean[] bits = getBitsForInt(i);
            Bitstring bitstring = new Bitstring(bits);
            int predictedFitness = model.getPredictedFitness(bitstring);
            int actualFitness = problem.fitness(bitstring);
            int delta = Math.abs(actualFitness - predictedFitness);
            totalError += delta;
        }

        return 255 - (totalError / 255);
    }

    private boolean[] getBitsForInt(int x) {

        boolean[] bits = new boolean[8];

        int factor = 128;

        for (int i = 0; i < 8; i++) {
            if (x >= factor) {
                bits[i] = true;
                x -= factor;
            }
            factor /= 2;
        }

        return bits;
    }
}
