package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 13:09
 */
public class TwoHundredProblem implements Problem {

    @Override
    public int fitness(Bitstring bitstring) {

        final boolean[] bits = bitstring.getBits();
        final int length = bits.length;

        assert length == 8;

        int term = (int) Math.pow(2, length-1);
        int total = 0;

        for (boolean bit : bits) {

            if (bit) {
                total += term;
            }

            term /= 2;
        }

        if (total < 200) {
            return total;
        } else {
            return 0;
        }


    }
}
