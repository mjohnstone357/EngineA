package util;

import java.util.List;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:19
 */
public class ListElementChecker {

    public static <T> boolean allElementsNonNull(List<T> ts) {
        for (T t : ts) {
            if (t == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean allNumbersNonNullAndNonZero(List<Integer> xs) {
        for (Integer x : xs) {
            if (x == null || x == 0) {
                return false;
            }
        }
        return true;
    }
}
