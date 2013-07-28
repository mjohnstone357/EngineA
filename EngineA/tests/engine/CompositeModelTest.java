package engine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:27
 */
public class CompositeModelTest {

    @Test
    public void should_give_correct_fitness_prediction_when_fitness_equal_but_weights_varied() {

        Bitstring bitstring = new Bitstring(8, "11100000");

        BitModel bitModel1 = new BitModel(0, 1000, 0);
        BitModel bitModel2 = new BitModel(1, 1000, 0);
        BitModel bitModel3 = new BitModel(2, 1000, 0);

        List<Model> models = new ArrayList<>();
        models.add(bitModel1);
        models.add(bitModel2);
        models.add(bitModel3);

        List<Integer> weightings = new ArrayList<>();
        weightings.add(100);
        weightings.add(200);
        weightings.add(300);

        CompositeModel compositeModel = new CompositeModel(models, weightings, 0);

        assertEquals(1000, compositeModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_fitness_prediction_when_fitness_varied_but_weightings_same() {

        Bitstring bitstring = new Bitstring(8, "11100000");

        BitModel bitModel1 = new BitModel(0, 1000, 0);
        BitModel bitModel2 = new BitModel(1, 4000, 0);
        BitModel bitModel3 = new BitModel(2, 1000, 0);

        List<Model> models = new ArrayList<>();
        models.add(bitModel1);
        models.add(bitModel2);
        models.add(bitModel3);

        List<Integer> weightings = new ArrayList<>();
        weightings.add(100);
        weightings.add(100);
        weightings.add(100);

        CompositeModel compositeModel = new CompositeModel(models, weightings, 0);

        assertEquals(2000, compositeModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_fitness_prediction_with_various_fitness_and_weighting_values() {

        Bitstring bitstring = new Bitstring(8, "11100000");

        BitModel bitModel1 = new BitModel(0, 1000, 0);
        BitModel bitModel2 = new BitModel(1, 2000, 0);
        BitModel bitModel3 = new BitModel(2, 5000, 0);

        List<Model> models = new ArrayList<>();
        models.add(bitModel1);
        models.add(bitModel2);
        models.add(bitModel3);

        List<Integer> weightings = new ArrayList<>();
        weightings.add(300);
        weightings.add(150);
        weightings.add(100);

        CompositeModel compositeModel = new CompositeModel(models, weightings, 0);

        assertEquals(2000, compositeModel.getPredictedFitness(bitstring));
    }

    @Test
    public void should_give_correct_fitness_prediction_with_composite_and_bit_models() {

        Bitstring bitstring = new Bitstring(8, "11100000");

        BitModel bitModel1 = new BitModel(0, 1000, 0);
        BitModel bitModel2 = new BitModel(1, 2000, 0);
        BitModel bitModel3 = new BitModel(2, 5000, 0);

        List<Model> models = new ArrayList<>();
        models.add(bitModel1);
        models.add(bitModel2);
        models.add(bitModel3);

        List<Integer> weightings = new ArrayList<>();
        weightings.add(300);
        weightings.add(150);
        weightings.add(100);

        CompositeModel compositeModel = new CompositeModel(models, weightings, 0); // Fitness value = 2000

        BitModel bitModel = new BitModel(0, 1000, 0); // Fitness value = 1000

        List<Model> models2 = new ArrayList<>();
        models2.add(compositeModel);
        models2.add(bitModel);

        List<Integer> weightings2 = new ArrayList<>();
        weightings2.add(100);
        weightings2.add(300);

        CompositeModel compositeModel2 = new CompositeModel(models2, weightings2, 0);

        assertEquals(1250, compositeModel2.getPredictedFitness(bitstring));
    }

}
