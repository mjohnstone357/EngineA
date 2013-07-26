package prototype;

import java.util.Map;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 13:54
 */
public class Component {

    private final Map<BitOpinion, Integer> bitOpinions;
    private final Map<Component,Integer> components;

    public Component(Map<BitOpinion, Integer> bitOpinions, Map<Component, Integer> components) {
        this.bitOpinions = bitOpinions;
        this.components = components;
    }
}
