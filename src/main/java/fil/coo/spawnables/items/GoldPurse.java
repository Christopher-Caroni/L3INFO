package fil.coo.spawnables.items;

import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.other.Selectable;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.Spawner;

public class GoldPurse implements Item, Selectable, ISingleSpawnable<GoldPurse> {

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
     * @return a random spawn of {@link GoldPurse} with a random amount of gold inside specified by {@link Spawner#getSpawnAmount(Spawner.Types)}.
     */
    @Override
    public GoldPurse getRandomSpawn() {
        int spawnAmount = Spawner.getSpawnAmount(Spawner.Types.GOLD);

        return new GoldPurse()
                .withGoldAmount(spawnAmount);
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
}
