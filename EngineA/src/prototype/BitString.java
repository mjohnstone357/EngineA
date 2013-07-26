package prototype;

import java.util.Arrays;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 12:56
 */
public class BitString {

    private final boolean[] bits;

    public BitString(boolean[] bits) {
        this.bits = bits;
    }

    public boolean[] getCopyOfBits() {
        boolean[] copy = new boolean[bits.length];
        System.arraycopy(bits, 0, copy, 0, bits.length);
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (boolean bit : bits) {
            builder.append(bit ? '1' : '0');
        }

        return builder.toString();
    }
}
