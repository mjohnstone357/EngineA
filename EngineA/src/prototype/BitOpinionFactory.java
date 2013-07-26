package prototype;

import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 13:14
 */
public class BitOpinionFactory {

    public static final int OPINION_MAX = 100;
    public static final int OPINION_MIN = -100;

    private final Random random;
    private final int stringLength;

    public BitOpinionFactory(int stringLength) {
        this.stringLength = stringLength;
        this.random = new Random();
    }


    public BitOpinion getBitOpinion() {

        final int index = random.nextInt(stringLength);
        final int opinion = randomOpinionValue(random);

        return new BitOpinion(index, opinion);

    }

    public static int randomOpinionValue(Random random) {
        return random.nextInt(201) - 100;
    }

}
