package engine;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 17:22
 */
public class CompositeModelGeneratorTest {

    @Test
    public void should_indicate_that_composite_creation_is_not_possible_without_existing_models() {

        final Random random = new Random();
        final Set<Model> existingModels = new HashSet<>();

        CompositeModelGenerator compositeModelGenerator = new CompositeModelGenerator(random, 8, existingModels);

        assertFalse(compositeModelGenerator.canCreateModel()); // Method under test
    }

    @Test
    public void should_create_a_composite_model_using_sole_bit_model() {

        final Random random = new Random();
        final Set<Model> existingModels = new HashSet<>();

        existingModels.add(new BitModel(0, 1000));

        CompositeModelGenerator compositeModelGenerator = new CompositeModelGenerator(random, 8, existingModels);

        assertTrue(compositeModelGenerator.canCreateModel()); // Method under test

        CompositeModel compositeModel = compositeModelGenerator.generateRandomCompositeModel(); // Method under test

        assertEquals(1000, compositeModel.getPredictedFitness(new Bitstring(8, "10000000")));
    }

    @Test
    public void should_create_a_composite_model_from_two_bit_models() {

        final Random random = new Random(0);
        final Set<Model> existingModels = new HashSet<>();

        existingModels.add(new BitModel(0, 1000));
        existingModels.add(new BitModel(0, 2000));

        CompositeModelGenerator compositeModelGenerator = new CompositeModelGenerator(random, 8, existingModels);

        assertTrue(compositeModelGenerator.canCreateModel()); // Method under test

        CompositeModel compositeModel = compositeModelGenerator.generateRandomCompositeModel(); // Method under test

        int compositeModelPredictedFitness = compositeModel.getPredictedFitness(new Bitstring(8, "10000000"));

        assertTrue(compositeModelPredictedFitness > 1000);
        assertTrue(compositeModelPredictedFitness < 2000);
    }

    @Test
    public void should_create_a_composite_model_from_one_of_two_bit_models() {

        final Random random = new Random(25641);
        final Set<Model> existingModels = new HashSet<>();

        existingModels.add(new BitModel(0, 1000));
        existingModels.add(new BitModel(0, 2000));

        CompositeModelGenerator compositeModelGenerator = new CompositeModelGenerator(random, 8, existingModels);

        assertTrue(compositeModelGenerator.canCreateModel()); // Method under test

        CompositeModel compositeModel = compositeModelGenerator.generateRandomCompositeModel(); // Method under test

        int compositeModelPredictedFitness = compositeModel.getPredictedFitness(new Bitstring(8, "10000000"));

        assertEquals(1000, compositeModelPredictedFitness);
    }



}
