package engine;

import org.junit.Test;
import util.Constants;

import static org.junit.Assert.assertEquals;

/**
 * @author Matthew Johnstone
 *         Date: 28/07/13
 *         Time: 16:37
 */
public class AbstractModelTest {

    @Test
    public void should_count_credits_correctly_with_bit_model() {
        Model bitModel = new AbstractModel() {
            @Override
            public int getPredictedFitness(Bitstring bits) {
                return 0;
            }
        };
        assertCreditOperations(bitModel);
    }

    private void assertCreditOperations(Model bitModel) {
        assertEquals(Constants.DEFAULT_CREDITS, bitModel.getCredits());

        bitModel.addCredits(50);
        assertEquals(Constants.DEFAULT_CREDITS + 50, bitModel.getCredits());

        bitModel.subtractCredits(25);
        assertEquals(Constants.DEFAULT_CREDITS + 25, bitModel.getCredits());
    }
}
