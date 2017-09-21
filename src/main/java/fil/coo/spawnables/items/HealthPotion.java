package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Potion;

import java.util.Random;

public class HealthPotion extends Potion implements ISingleSpawnable<HealthPotion> {

    private int healthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeHP(healthBoost);
    }

    @Override
    public String getMenuDescription() {
        return "Health potion: +" + healthBoost + " health";
    }

    @Override
    public HealthPotion getRandomSpawn() {
        if (willSpawn()) {
            return new HealthPotion()
                    .withHealthBoost(getRandomAmountHeld());
        }
        return null;
    }

    private HealthPotion withHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
        return this;
    }

    @Override
    public int getRandomAmountHeld() {
        return new Random().nextInt(21);
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
