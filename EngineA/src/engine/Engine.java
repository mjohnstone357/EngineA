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

    private Problem problem;

    public Engine() {

        models = new ArrayList<>();
        Random random = new Random();
        bitstringGenerator = new BitstringGenerator(random, 8);
        modelGenerator = new ModelGenerator(random, 8, models);

        problem = new TwoHundredProblem();

    }

    public List<Model> getModels() {
        return models;
    }

    public static void main(String[] args) {

        Engine engine = new Engine();

        Bitstring opt = new Bitstring(8, "11000111");


        for (Model model : engine.getModels()) {
            System.out.println("Model: " + model + " puts OPT's fitness at " + model.getPredictedFitness(opt));
        }
    }
}
