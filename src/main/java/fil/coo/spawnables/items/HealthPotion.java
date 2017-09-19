package fil.coo.spawnables.items;

import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Potion;

public class HealthPotion implements Potion, ISingleSpawnable<HealthPotion> {
    @Override
    public void use() {
//        TODO
    }

    @Override
    public String getMenuDescription() {
        // TODO
        return null;
    }

    @Override
    public HealthPotion getRandomSpawn() {
        // TODO
        return null;
    }

    @Override
    public int getUpperSpawnBoundForAmountHeld() {
        // TODO
        return 0;
    }

    @Override
    public double getSpawnRate() {
        // TODO
        return 0;
    }

    @Override
    public boolean willSpawn() {
        // TODO
        return false;
    }
}
