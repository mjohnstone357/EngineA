package prototype;

import java.util.*;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 15:36
 */
public class SubsetUtils<T> {

    public Set<T> getRandomSubset(Set<T> set) {

        Random random = new Random();

        List<T> tList = new ArrayList<>(set);

        int numberToRemove = random.nextInt(set.size() + 1);

        for (int i = 0; i < numberToRemove; i++) {
            int indexToRemove = random.nextInt(tList.size());
            tList.remove(indexToRemove);
        }

        return new HashSet<>(tList);
    }

}
