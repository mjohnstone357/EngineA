package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 13:07
 */
public class BitStringFactory {

    private final int stringLength;
    private final Random random;

    public BitStringFactory(int stringLength) {
        this.stringLength = stringLength;
        random = new Random();
    }

    public BitString getBitString() {

        final boolean[] bits = new boolean[stringLength];

        for (int i = 0; i < stringLength; i++) {
            bits[i] = random.nextBoolean();
        }

        return new BitString(bits);
    }

    public List<BitString> getBatch(int numberOfStrings) {

        final List<BitString> strings = new ArrayList<BitString>();

        for (int i = 0; i < numberOfStrings; i++) {
            strings.add(getBitString());
        }

        return strings;
    }

}
