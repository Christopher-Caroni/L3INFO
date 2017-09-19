package fil.coo.spawnables.items;

import fil.coo.other.Selectable;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.Random;

public class GoldPurse implements Item, ISingleSpawnable<GoldPurse> {

    /**
     * The amount of gold this purse contains.
     */
    private int goldAmount;

    @Override
    public void use() {
        // TODO
    }

    @Override
    public String getMenuDescription() {
        return "Gold purse: " + goldAmount + " gold.";
    }


    /**
     * @return a random spawn of {@link GoldPurse} with a random amount of gold inside specified by {@link #getSpawnRate()}
     */
    @Override
    public GoldPurse getRandomSpawn() {
        if (willSpawn()) {

            return new GoldPurse()
                    .withGoldAmount(getUpperSpawnBoundForAmountHeld());
        }
        return null;
    }


    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    /**
     * @param goldAmount the amount of gold this purse should hold.
     * @return this instance
     */
    public GoldPurse withGoldAmount(int goldAmount) {
        this.setGoldAmount(goldAmount);
        return this;
    }

    @Override
    public int getUpperSpawnBoundForAmountHeld() {
        return 21;
    }

    @Override
    public double getSpawnRate() {
        return 0.2;
    }

    @Override
    public boolean willSpawn() {
        return new Random().nextDouble() <= getSpawnRate();
    }

}
