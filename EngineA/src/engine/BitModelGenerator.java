package engine;

import util.Constants;

import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 16:26
 */
public class BitModelGenerator {

    private final Random random;
    private final int stringLength;

    public BitModelGenerator(Random random, int stringLength) {
        this.random = random;
        this.stringLength = stringLength;
    }

    public BitModel generateRandomBitModel() {

        final int index = random.nextInt(stringLength);
        final int weighting = getRandomWeighting();

        return new BitModel(index, weighting);

    }

    public int getRandomWeighting() {
        return 1 + random.nextInt(Constants.MAX_WEIGHTING - 1);
    }
}
