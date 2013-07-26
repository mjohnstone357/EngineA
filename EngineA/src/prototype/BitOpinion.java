package prototype;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 12:51
 */
public class BitOpinion {

    private final int bitIndex;
    private final int opinion;

    private int credits;


    public BitOpinion(int bitIndex, int opinion) {

        assert bitIndex >= 0;
        assert opinion >= BitOpinionFactory.OPINION_MIN && opinion <= BitOpinionFactory.OPINION_MAX;

        this.bitIndex = bitIndex;
        this.opinion = opinion;

        this.credits = Constants.BIT_OPINION_CREDIT_DEFAULT;
    }
}
