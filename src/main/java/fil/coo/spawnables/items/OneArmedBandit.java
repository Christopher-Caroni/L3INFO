package fil.coo.spawnables.items;

import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.interfaces.Spawnable;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.Random;

public class OneArmedBandit implements Item, ISingleSpawnable<OneArmedBandit> {


    /**
     * The player must have enough money to use the {@link OneArmedBandit} otherwise he disappears. If he gives him the money, the oneArmedBandit gives him a random item which is used by the player immediately.
     */
    @Override
    public void use() {
        // TODO spawn random object and give it to user who uses it right away
//        Spawnable randomObject = spawnRandomObject();

    }

    /**
     * @return an item that will be used by the player immediately
     */
    private Spawnable spawnRandomObject() {
        return null;
    }

    @Override
    public String getMenuDescription() {
        // TODO
        return null;
    }

    @Override
    public OneArmedBandit getRandomSpawn() {
        if (willSpawn()) {
            return new OneArmedBandit();
        }
        return null;
    }

    @Override
    public int getUpperSpawnBoundForAmountHeld() {
        return 0;
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
