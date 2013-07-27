package engine;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 12:28
 */
public class Bitstring {

    private boolean[] bits;

    public Bitstring(int length, String binary) {

        int stringLength = binary.length();
        assert length >= stringLength;
        int offset = length - stringLength;

        bits = new boolean[length];

        for (int i = 0; i < stringLength; i++) {

            int j = i + offset;

            char c = binary.charAt(i);
            if (c == '1') {
                bits[j] = true;
            }
        }
    }

    public boolean[] getBits() {
        return bits;
    }

}
