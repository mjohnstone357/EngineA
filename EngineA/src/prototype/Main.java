package prototype;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Matthew Johnstone
 *         Date: 21/07/13
 *         Time: 13:06
 */
public class Main {

    public static void main(String[] args) {

        BitStringFactory bitStringFactory = new BitStringFactory(8);
        BitOpinionFactory bitOpinionFactory = new BitOpinionFactory(8);
        ComponentFactory componentFactory = new ComponentFactory();


        List<BitString> bitStrings = bitStringFactory.getBatch(10);

        Set<BitOpinion> opinions = new HashSet<>();
        Set<Component> components = new HashSet<>();

        opinions.add(bitOpinionFactory.getBitOpinion());
        opinions.add(bitOpinionFactory.getBitOpinion());
        opinions.add(bitOpinionFactory.getBitOpinion());
        opinions.add(bitOpinionFactory.getBitOpinion());

        components.add(componentFactory.getComponent(opinions, components));
        components.add(componentFactory.getComponent(opinions, components));
        components.add(componentFactory.getComponent(opinions, components));
        components.add(componentFactory.getComponent(opinions, components));

        System.out.println();
    }

}
