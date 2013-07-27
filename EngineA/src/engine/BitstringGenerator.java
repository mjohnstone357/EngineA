package engine;

import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:59
 */
public class BitstringGenerator {

    private final Random random;
    private final int stringLength;

    public BitstringGenerator(Random random, int stringLength) {

        assert random != null && stringLength >= 0;

        this.random = random;
        this.stringLength = stringLength;
    }

    public Bitstring generateRandomBitstring() {

        boolean[] bits = new boolean[stringLength];

        for (int i = 0; i < stringLength; i++) {
            bits[i] = random.nextBoolean();
        }

        return new Bitstring(bits);
    }
}
