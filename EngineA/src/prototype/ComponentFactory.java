package prototype;

import java.util.*;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 15:25
 */
public class ComponentFactory {

    private static SubsetUtils<BitOpinion> bitOpinionUtil = new SubsetUtils<>();
    private static SubsetUtils<Component> componentUtil = new SubsetUtils<>();

    public Component getComponent(Set<BitOpinion> opinions, Set<Component> components) {

        Random random = new Random();

        Map<BitOpinion, Integer> selectedOpinions = new HashMap<>();
        Map<Component, Integer> selectedComponents = new HashMap<>();

        // Select a random subset of opinions
        Set<BitOpinion> opinionSubset = bitOpinionUtil.getRandomSubset(opinions);
        Set<Component> componentSubset = componentUtil.getRandomSubset(components);

        for (BitOpinion bitOpinion : opinionSubset) {
            selectedOpinions.put(bitOpinion, BitOpinionFactory.randomOpinionValue(random));
        }

        for (Component component : componentSubset) {
            selectedComponents.put(component, BitOpinionFactory.randomOpinionValue(random));
        }

        return new Component(selectedOpinions, selectedComponents);

    }



}
