package engine;

import util.Constants;

/**
 * @author Matthew Johnstone
 *         Date: 28/07/13
 *         Time: 16:35
 */
public abstract class AbstractModel implements Model {

    protected int credits;

    protected AbstractModel() {
        this.credits = Constants.DEFAULT_CREDITS;
    }

    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public int addCredits(int credits) {
        this.credits += credits;
        return this.credits;
    }

    @Override
    public int subtractCredits(int credits) {
        this.credits -= credits;
        return this.credits;
    }

}
