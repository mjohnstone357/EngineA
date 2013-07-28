package engine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Matthew Johnstone
 *         Date: 28/07/13
 *         Time: 12:20
 */
public class ModelGeneratorTest {

    @Test
    public void should_create_a_bit_model_when_composite_models_are_unavailable() {

        Random mockRandom = createMock(Random.class);
        replay(mockRandom);

        List<Model> existingModels = new ArrayList<>();

        final BitModel bitModel = createNiceMock(BitModel.class);

        ModelGenerator modelGenerator = new ModelGenerator(mockRandom, 8, existingModels) {
            @Override
            protected CompositeModelGenerator getCompositeModelGenerator(Random random, int stringLength, List<Model> existingModels) {
                CompositeModelGenerator compositeModelGenerator = createMock(CompositeModelGenerator.class);
                expect(compositeModelGenerator.canCreateModel()).andReturn(false).once();
                replay(compositeModelGenerator);
                return compositeModelGenerator;
            }

            @Override
            protected BitModelGenerator getBitModelGenerator(Random random, int stringLength) {
                BitModelGenerator bitModelGenerator = createMock(BitModelGenerator.class);
                expect(bitModelGenerator.generateRandomBitModel()).andReturn(bitModel).once();
                replay(bitModelGenerator);
                return bitModelGenerator;
            }
        };

        Model randomModel = modelGenerator.createRandomModel();// Method under test

        assertEquals(bitModel, randomModel);

    }

    @Test
    public void should_create_a_bit_model_when_composite_models_are_available_but_random_bool_is_true() {

        Random mockRandom = createMock(Random.class);
        expect(mockRandom.nextBoolean()).andReturn(true);
        replay(mockRandom);

        List<Model> existingModels = new ArrayList<>();
        existingModels.add(createNiceMock(BitModel.class)); // There is an existing model, so a composite model could be created

        final BitModel bitModel = createNiceMock(BitModel.class);

        ModelGenerator modelGenerator = new ModelGenerator(mockRandom, 8, existingModels) {
            @Override
            protected CompositeModelGenerator getCompositeModelGenerator(Random random, int stringLength, List<Model> existingModels) {
                CompositeModelGenerator compositeModelGenerator = createMock(CompositeModelGenerator.class);
                expect(compositeModelGenerator.canCreateModel()).andReturn(true).once();
                replay(compositeModelGenerator);
                return compositeModelGenerator;
            }

            @Override
            protected BitModelGenerator getBitModelGenerator(Random random, int stringLength) {
                BitModelGenerator bitModelGenerator = createMock(BitModelGenerator.class);
                expect(bitModelGenerator.generateRandomBitModel()).andReturn(bitModel).once();
                replay(bitModelGenerator);
                return bitModelGenerator;
            }
        };

        Model randomModel = modelGenerator.createRandomModel();// Method under test

        assertEquals(bitModel, randomModel);

    }

    @Test
    public void should_create_a_composite_model_when_composite_models_are_available_and_random_bool_is_false() {

        Random mockRandom = createMock(Random.class);
        expect(mockRandom.nextBoolean()).andReturn(false);
        replay(mockRandom);

        List<Model> existingModels = new ArrayList<>();
        existingModels.add(createNiceMock(BitModel.class)); // There is an existing model, so a composite model can be created

        final CompositeModel compositeModel = createNiceMock(CompositeModel.class);

        ModelGenerator modelGenerator = new ModelGenerator(mockRandom, 8, existingModels) {
            @Override
            protected CompositeModelGenerator getCompositeModelGenerator(Random random, int stringLength, List<Model> existingModels) {
                CompositeModelGenerator compositeModelGenerator = createMock(CompositeModelGenerator.class);
                expect(compositeModelGenerator.canCreateModel()).andReturn(true).once();
                expect(compositeModelGenerator.generateRandomCompositeModel()).andReturn(compositeModel).once();
                replay(compositeModelGenerator);
                return compositeModelGenerator;
            }

            @Override
            protected BitModelGenerator getBitModelGenerator(Random random, int stringLength) {
                BitModelGenerator bitModelGenerator = createMock(BitModelGenerator.class);
                replay(bitModelGenerator);
                return bitModelGenerator;
            }
        };

        Model randomModel = modelGenerator.createRandomModel();// Method under test

        assertEquals(compositeModel, randomModel);

    }

    @Test
    public void testGetCompositeModelGenerator() throws Exception {

        Random mockRandom = createNiceMock(Random.class);
        int stringLength = 8;
        ArrayList<Model> existingModels = new ArrayList<>();

        ModelGenerator modelGenerator = new ModelGenerator(mockRandom, stringLength, existingModels);

        assertNotNull(modelGenerator.getBitModelGenerator(mockRandom, stringLength));
        assertNotNull(modelGenerator.getCompositeModelGenerator(mockRandom, stringLength, existingModels));

    }
}
